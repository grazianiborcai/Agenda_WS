package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.PayordVisiDaoUpdate;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMultmoipPay;
import br.com.mind5.payment.payOrder.model.action.PayordVisiOrderRefresh;
import br.com.mind5.payment.payOrder.model.action.PayordVisiPayordemUpdate;

public final class PayordNodePay extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordNodePay(DeciTreeOption<PayordInfo> option) {
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
	
		ActionStd<PayordInfo> multmoipPay = new ActionStdCommom<PayordInfo>(option, PayordVisiMultmoipPay.class);
		ActionLazy<PayordInfo> updatePayord = new ActionLazyCommom<PayordInfo>(option, PayordVisiDaoUpdate.class);
		ActionLazy<PayordInfo> updatePayordem = new ActionLazyCommom<PayordInfo>(option, PayordVisiPayordemUpdate.class);
		ActionLazy<PayordInfo> orderRefresh = new ActionLazyCommom<PayordInfo>(option, PayordVisiOrderRefresh.class);
		
		multmoipPay.addPostAction(updatePayord);
		updatePayord.addPostAction(updatePayordem);
		updatePayordem.addPostAction(orderRefresh);
		
		actions.add(multmoipPay);		
		return actions;
	}
}
