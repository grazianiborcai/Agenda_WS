package br.com.mind5.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuMergeOrdist;
import br.com.mind5.payment.refundOrder.model.action.StdRefuOrderRefunding;

public final class NodeRefuOrder extends DeciTreeTemplateWrite<RefuInfo> {
	
	public NodeRefuOrder(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuInfo> buildCheckerHook(DeciTreeOption<RefuInfo> option) {
		List<ModelChecker<RefuInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuInfo> option) {
		List<ActionStd<RefuInfo>> actions = new ArrayList<>();		

		ActionStd<RefuInfo> orderRefund = new StdRefuOrderRefunding(option);
		ActionLazy<RefuInfo> mergeOrdist = new LazyRefuMergeOrdist(option.conn, option.schemaName);
		
		orderRefund.addPostAction(mergeOrdist);
		
		actions.add(orderRefund);		
		return actions;
	}
}
