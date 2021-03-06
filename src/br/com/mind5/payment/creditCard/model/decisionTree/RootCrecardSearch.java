package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardEnforceUserKey;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeCrecarch;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardRootSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckSearch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class RootCrecardSearch extends DeciTreeTemplateRead<CrecardInfo> {
	
	public RootCrecardSearch(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> nodeUser = new NodeCrecardUser(option).toAction();
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
