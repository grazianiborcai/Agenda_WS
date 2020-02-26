package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordOrderRefresh;
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
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
	
		ActionStd<PayordInfo> multmoipPay = new StdPayordMultmoipPay(option);
		ActionLazy<PayordInfo> orderRefresh = new LazyPayordOrderRefresh(option.conn, option.schemaName);
		
		multmoipPay.addPostAction(orderRefresh);
		
		actions.add(multmoipPay);		
		return actions;
	}
}
