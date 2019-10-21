package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusNodeSignupL2;
import br.com.mind5.business.customer.model.action.StdCusMergeCusarchByCpf;
import br.com.mind5.business.customer.model.checker.CusCheckHasCus;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

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

		ActionStd<CusInfo> searchCustomerByCpf = new StdCusMergeCusarchByCpf(option);
		ActionLazy<CusInfo> nodeSignupL2 = new LazyCusNodeSignupL2(option.conn, option.schemaName);
		
		searchCustomerByCpf.addPostAction(nodeSignupL2);
		
		actions.add(searchCustomerByCpf);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnFailedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> nodeSignupL2 = new NodeCusSignupL2(option).toAction();
		
		actions.add(nodeSignupL2);		
		return actions;
	}
}
