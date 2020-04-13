package br.com.mind5.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuRefundRefem;
import br.com.mind5.payment.refundOrder.model.action.StdRefuMergePayormarch;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckDummy;

public final class NodeRefuRefund extends DeciTreeTemplateWriteV1<RefuInfo> {
	
	public NodeRefuRefund(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuInfo> buildCheckerHook(DeciTreeOption<RefuInfo> option) {
		List<ModelCheckerV1<RefuInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuInfo> checker;	

		checker = new RefuCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
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
