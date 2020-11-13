package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardEnforceUserKey;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeCrecarch;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardRootSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckSearch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class RootCrecardSearch extends DeciTreeTemplateReadV2<CrecardInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV2<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV2<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CrecardInfo> nodeUser = new NodeCrecardUser(option).toAction();
		ActionLazy<CrecardInfo> enforceUserKey = new LazyCrecardEnforceUserKey(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> mergeCrecarch = new LazyCrecardMergeCrecarch(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> user = new LazyCrecardRootSelect(option.conn, option.schemaName);
		
		nodeUser.addPostAction(enforceUserKey);
		enforceUserKey.addPostAction(mergeCrecarch);
		mergeCrecarch.addPostAction(user);
		
		actions.add(nodeUser);
		return actions;
	}
}
