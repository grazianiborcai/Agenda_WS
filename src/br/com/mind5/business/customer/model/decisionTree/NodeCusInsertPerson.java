package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusDaoUpdate;
import br.com.mind5.business.customer.model.action.LazyCusPersonInsert;
import br.com.mind5.business.customer.model.action.StdCusEnforcePersonKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCusInsertPerson extends DeciTreeTemplateWrite<CusInfo> {
	
	public NodeCusInsertPerson(DeciTreeOption<CusInfo> option) {
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
		
		ActionStd<CusInfo> enforcePersonKey = new StdCusEnforcePersonKey(option);
		ActionLazy<CusInfo> insertPerson = new LazyCusPersonInsert(option.conn, option.schemaName);		
		ActionLazy<CusInfo> update = new LazyCusDaoUpdate(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(insertPerson);
		insertPerson.addPostAction(update);
		
		actions.add(enforcePersonKey);	
		return actions;
	}
}
