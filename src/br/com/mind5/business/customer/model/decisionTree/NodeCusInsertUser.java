package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusEnforceUserCateg;
import br.com.mind5.business.customer.model.action.LazyCusInsertUser;
import br.com.mind5.business.customer.model.action.StdCusEnforceAuthGroup;
import br.com.mind5.business.customer.model.checker.CusCheckInsertUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusInsertUser extends DeciTreeWriteTemplate<CusInfo> {
	
	public NodeCusInsertUser(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;	
		
		checker = new CusCheckInsertUser();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> enforceAuthGroup = new StdCusEnforceAuthGroup(option);
		ActionLazy<CusInfo> enforceUserCateg = new LazyCusEnforceUserCateg(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertUser = new LazyCusInsertUser(option.conn, option.schemaName);
		
		enforceAuthGroup.addPostAction(enforceUserCateg);	
		enforceUserCateg.addPostAction(insertUser);	
		
		actions.add(enforceAuthGroup);	
		return actions;
	}
}
