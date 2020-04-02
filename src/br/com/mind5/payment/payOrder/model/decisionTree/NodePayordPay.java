package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordOrderRefresh;
import br.com.mind5.payment.payOrder.model.action.LazyPayordUpdate;
import br.com.mind5.payment.payOrder.model.action.LazyPayordUpdatePayordem;
import br.com.mind5.payment.payOrder.model.action.StdPayordMultmoipPay;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckDummy;

public final class NodePayordPay extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordPay(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		
		checker = new PayordCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	//TODO: Ciclo de pagamento dever ser: 1) pre-autorizacao; 2) pagamento
	@Override protected List<ActionStdV1<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV1<PayordInfo>> actions = new ArrayList<>();		
	
		ActionStdV1<PayordInfo> multmoipPay = new StdPayordMultmoipPay(option);
		ActionLazyV1<PayordInfo> updatePayord = new LazyPayordUpdate(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> updatePayordem = new LazyPayordUpdatePayordem(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> orderRefresh = new LazyPayordOrderRefresh(option.conn, option.schemaName);
		
		multmoipPay.addPostAction(updatePayord);
		updatePayord.addPostAction(updatePayordem);
		updatePayordem.addPostAction(orderRefresh);
		
		actions.add(multmoipPay);		
		return actions;
	}
}
