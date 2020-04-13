package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardEnforceUserKey;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeCrecarch;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardRootSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckSearch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class RootCrecardSearch extends DeciTreeTemplateReadV1<CrecardInfo> {
	
	public RootCrecardSearch(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelCheckerV1<CrecardInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CrecardInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CrecardInfo> nodeUser = new NodeCrecardUser(option).toAction();
		ActionLazyV1<CrecardInfo> enforceUserKey = new LazyCrecardEnforceUserKey(option.conn, option.schemaName);
		ActionLazyV1<CrecardInfo> mergeCrecarch = new LazyCrecardMergeCrecarch(option.conn, option.schemaName);
		ActionLazyV1<CrecardInfo> user = new LazyCrecardRootSelect(option.conn, option.schemaName);
		
		nodeUser.addPostAction(enforceUserKey);
		enforceUserKey.addPostAction(mergeCrecarch);
		mergeCrecarch.addPostAction(user);
		
		actions.add(nodeUser);
		return actions;
	}
}
