package br.com.gda.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.action.LazyPayordInsert;
import br.com.gda.payment.payOrder.model.action.StdPayordInsertCuspar;
import br.com.gda.payment.payOrder.model.checker.PayordCheckOrderStatus;
import br.com.gda.payment.payOrder.model.checker.PayordCheckOrderUser;

public final class NodePayordPay extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordPay(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		
		checker = new PayordCheckOrderUser();
		queue.add(checker);
		
		checker = new PayordCheckOrderStatus();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> insertCuspar = new StdPayordInsertCuspar(option);	
		ActionLazy<PayordInfo> insertPayord = new LazyPayordInsert(option.conn, option.schemaName);
		
		insertCuspar.addPostAction(insertPayord);
		
		actions.add(insertCuspar);		
		return actions;
	}
}
