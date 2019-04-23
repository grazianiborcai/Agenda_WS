package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusNodeInsertUser;
import br.com.gda.business.customer.model.action.LazyCusUpdate;
import br.com.gda.business.customer.model.checker.CusCheckHasCus;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusSignupL1 extends DeciTreeWriteTemplate<CusInfo> {
	
	public NodeCusSignupL1(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean DONT_HAVE_CUSTOMER = false;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_HAVE_CUSTOMER;	
		checker = new CusCheckHasCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> insertCustomer = new NodeCusInsert(option).toAction();
		ActionLazy<CusInfo> insertUser = new LazyCusNodeInsertUser(option.conn, option.schemaName);
		ActionLazy<CusInfo> updateCustomer = new LazyCusUpdate(option.conn, option.schemaName);

		insertCustomer.addPostAction(insertUser);
		insertUser.addPostAction(updateCustomer);
		
		actions.add(insertCustomer);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnFailedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> nodeSignupL2 = new NodeCusSignupL2(option).toAction();
		
		actions.add(nodeSignupL2);		
		return actions;
	}
}
