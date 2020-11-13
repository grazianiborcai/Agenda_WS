package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusNodeInsertUserL1;
import br.com.mind5.business.customer.model.action.LazyCusRootInsertSilent;
import br.com.mind5.business.customer.model.action.LazyCusRootSelect;
import br.com.mind5.business.customer.model.action.StdCusEnforceUserCod;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootCusInsert extends DeciTreeTemplateWrite<CusInfo> {

	public RootCusInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;		

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> obfuscateUser = new StdCusEnforceUserCod(option);
		ActionLazy<CusInfo> insert = new LazyCusRootInsertSilent(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertUser = new LazyCusNodeInsertUserL1(option.conn, option.schemaName);				
		ActionLazy<CusInfo> select = new LazyCusRootSelect(option.conn, option.schemaName);	
		
		obfuscateUser.addPostAction(insert);
		insert.addPostAction(insertUser);
		insertUser.addPostAction(select);
		
		actions.add(obfuscateUser);	
		return actions;
	}
}
