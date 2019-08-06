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
import br.com.gda.payment.payOrder.model.action.LazyPayordMultmoipPay;
import br.com.gda.payment.payOrder.model.action.LazyPayordOrderUpdate;
import br.com.gda.payment.payOrder.model.action.LazyPayordUpdate;
import br.com.gda.payment.payOrder.model.action.LazyPayordUpdatePayordem;
import br.com.gda.payment.payOrder.model.action.StdPayordInsert;
import br.com.gda.payment.payOrder.model.action.LazyPayordInsertPayordem;
import br.com.gda.payment.payOrder.model.checker.PayordCheckCrecardUser;
import br.com.gda.payment.payOrder.model.checker.PayordCheckCusparUser;
import br.com.gda.payment.payOrder.model.checker.PayordCheckLatestStatus;
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
		
		checker = new PayordCheckCusparUser();
		queue.add(checker);
		
		checker = new PayordCheckCrecardUser();
		queue.add(checker);
		
		checker = new PayordCheckLatestStatus();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	//TODO: Ciclo de pagamento dever ser: 1) pre-autorizacao; 2) pagamento
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> insertPayord = new StdPayordInsert(option);	
		ActionLazy<PayordInfo> insertPayordem = new LazyPayordInsertPayordem(option.conn, option.schemaName);		
		ActionLazy<PayordInfo> multmoipPay = new LazyPayordMultmoipPay(option.conn, option.schemaName);
		ActionLazy<PayordInfo> updatePayord = new LazyPayordUpdate(option.conn, option.schemaName);
		ActionLazy<PayordInfo> updatePayordem = new LazyPayordUpdatePayordem(option.conn, option.schemaName);
		ActionLazy<PayordInfo> updateOrder = new LazyPayordOrderUpdate(option.conn, option.schemaName);
		
		insertPayord.addPostAction(insertPayordem);
		insertPayordem.addPostAction(multmoipPay);
		multmoipPay.addPostAction(updatePayord);
		updatePayord.addPostAction(updatePayordem);
		updatePayordem.addPostAction(updateOrder);
		
		actions.add(insertPayord);		
		return actions;
	}
}
