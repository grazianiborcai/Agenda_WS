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
import br.com.mind5.payment.refundOrder.model.action.LazyRefuRefundRefem;
import br.com.mind5.payment.refundOrder.model.action.StdRefuMergePayormarch;

public final class NodeRefuRefund extends DeciTreeTemplateWrite<RefuInfo> {
	
	public NodeRefuRefund(DeciTreeOption<RefuInfo> option) {
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

		ActionStd<RefuInfo> mergePayormarch = new StdRefuMergePayormarch(option);
		ActionLazy<RefuInfo> refundRefem = new LazyRefuRefundRefem(option.conn, option.schemaName);
		
		mergePayormarch.addPostAction(refundRefem);
		
		actions.add(mergePayormarch);		
		return actions;
	}
}
