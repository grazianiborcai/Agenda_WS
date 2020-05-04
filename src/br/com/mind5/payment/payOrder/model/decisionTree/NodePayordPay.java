package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordDaoUpdate;
import br.com.mind5.payment.payOrder.model.action.LazyPayordOrderRefresh;
import br.com.mind5.payment.payOrder.model.action.LazyPayordUpdatePayordem;
import br.com.mind5.payment.payOrder.model.action.StdPayordMultmoipPay;

public final class NodePayordPay extends DeciTreeTemplateWriteV2<PayordInfo> {
	
	public NodePayordPay(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelCheckerV1<PayordInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	//TODO: Ciclo de pagamento dever ser: 1) pre-autorizacao; 2) pagamento
	@Override protected List<ActionStdV1<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV1<PayordInfo>> actions = new ArrayList<>();		
	
		ActionStdV1<PayordInfo> multmoipPay = new StdPayordMultmoipPay(option);
		ActionLazyV1<PayordInfo> updatePayord = new LazyPayordDaoUpdate(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> updatePayordem = new LazyPayordUpdatePayordem(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> orderRefresh = new LazyPayordOrderRefresh(option.conn, option.schemaName);
		
		multmoipPay.addPostAction(updatePayord);
		updatePayord.addPostAction(updatePayordem);
		updatePayordem.addPostAction(orderRefresh);
		
		actions.add(multmoipPay);		
		return actions;
	}
}
