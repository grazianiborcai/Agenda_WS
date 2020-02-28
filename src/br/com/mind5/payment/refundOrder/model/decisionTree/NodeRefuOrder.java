package br.com.mind5.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuMergeOrdemarch;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuMergeOrdist;
import br.com.mind5.payment.refundOrder.model.action.StdRefuOrderRefunding;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckDummy;

public final class NodeRefuOrder extends DeciTreeWriteTemplate<RefuInfo> {
	
	public NodeRefuOrder(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuInfo> buildDecisionCheckerHook(DeciTreeOption<RefuInfo> option) {
		List<ModelChecker<RefuInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuInfo> checker;	

		checker = new RefuCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuInfo> option) {
		List<ActionStd<RefuInfo>> actions = new ArrayList<>();		

		ActionStd<RefuInfo> orderRefund = new StdRefuOrderRefunding(option);
		ActionLazy<RefuInfo> mergeOrdist = new LazyRefuMergeOrdist(option.conn, option.schemaName);
		ActionLazy<RefuInfo> mergeOrdemarch = new LazyRefuMergeOrdemarch(option.conn, option.schemaName);
		
		orderRefund.addPostAction(mergeOrdist);
		mergeOrdist.addPostAction(mergeOrdemarch);
		
		actions.add(orderRefund);		
		return actions;
	}
}
