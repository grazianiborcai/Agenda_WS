package br.com.mind5.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuRefundRefem;
import br.com.mind5.payment.refundOrder.model.action.StdRefuMergePayormarch;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckDummy;

public final class NodeRefuRefund extends DeciTreeWriteTemplate<RefuInfo> {
	
	public NodeRefuRefund(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuInfo> buildCheckerHook(DeciTreeOption<RefuInfo> option) {
		List<ModelChecker<RefuInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuInfo> checker;	

		checker = new RefuCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuInfo> option) {
		List<ActionStdV1<RefuInfo>> actions = new ArrayList<>();		

		ActionStdV1<RefuInfo> mergePayormarch = new StdRefuMergePayormarch(option);
		ActionLazyV1<RefuInfo> refundRefem = new LazyRefuRefundRefem(option.conn, option.schemaName);
		
		mergePayormarch.addPostAction(refundRefem);
		
		actions.add(mergePayormarch);		
		return actions;
	}
}
