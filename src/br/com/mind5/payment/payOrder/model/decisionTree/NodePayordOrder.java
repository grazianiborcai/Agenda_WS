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
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeOrder;
import br.com.mind5.payment.payOrder.model.action.StdPayordOrderPay;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckDummy;

public final class NodePayordOrder extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordOrder(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		
		checker = new PayordCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> orderPay = new StdPayordOrderPay(option);
		ActionLazy<PayordInfo> mergeOrder = new LazyPayordMergeOrder(option.conn, option.schemaName);
			
		orderPay.addPostAction(mergeOrder);
		
		actions.add(orderPay);		
		return actions;
	}
}
