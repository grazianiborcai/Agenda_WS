package br.com.mind5.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuMergeOrdist;
import br.com.mind5.payment.refundOrder.model.action.StdRefuOrderRefunding;

public final class NodeRefuOrder extends DeciTreeTemplateWriteV2<RefuInfo> {
	
	public NodeRefuOrder(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuInfo> buildCheckerHook(DeciTreeOption<RefuInfo> option) {
		List<ModelCheckerV1<RefuInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuInfo> option) {
		List<ActionStdV1<RefuInfo>> actions = new ArrayList<>();		

		ActionStdV1<RefuInfo> orderRefund = new StdRefuOrderRefunding(option);
		ActionLazy<RefuInfo> mergeOrdist = new LazyRefuMergeOrdist(option.conn, option.schemaName);
		
		orderRefund.addPostAction(mergeOrdist);
		
		actions.add(orderRefund);		
		return actions;
	}
}
