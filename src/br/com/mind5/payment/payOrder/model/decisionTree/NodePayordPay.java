package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordDaoUpdate;
import br.com.mind5.payment.payOrder.model.action.LazyPayordOrderRefresh;
import br.com.mind5.payment.payOrder.model.action.LazyPayordUpdatePayordem;
import br.com.mind5.payment.payOrder.model.action.StdPayordMultmoipPay;

public final class NodePayordPay extends DeciTreeTemplateWrite<PayordInfo> {
	
	public NodePayordPay(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	//TODO: Ciclo de pagamento dever ser: 1) pre-autorizacao; 2) pagamento
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
	
		ActionStd<PayordInfo> multmoipPay = new StdPayordMultmoipPay(option);
		ActionLazy<PayordInfo> updatePayord = new LazyPayordDaoUpdate(option.conn, option.schemaName);
		ActionLazy<PayordInfo> updatePayordem = new LazyPayordUpdatePayordem(option.conn, option.schemaName);
		ActionLazy<PayordInfo> orderRefresh = new LazyPayordOrderRefresh(option.conn, option.schemaName);
		
		multmoipPay.addPostAction(updatePayord);
		updatePayord.addPostAction(updatePayordem);
		updatePayordem.addPostAction(orderRefresh);
		
		actions.add(multmoipPay);		
		return actions;
	}
}
