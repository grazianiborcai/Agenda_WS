package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeOrder;
import br.com.mind5.payment.payOrder.model.action.StdPayordOrderPay;

public final class NodePayordOrder extends DeciTreeTemplateWriteV2<PayordInfo> {
	
	public NodePayordOrder(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelCheckerV1<PayordInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV2<PayordInfo>> actions = new ArrayList<>();		

		ActionStdV2<PayordInfo> orderPay = new StdPayordOrderPay(option);
		ActionLazy<PayordInfo> mergeOrder = new LazyPayordMergeOrder(option.conn, option.schemaName);
			
		orderPay.addPostAction(mergeOrder);
		
		actions.add(orderPay);		
		return actions;
	}
}
