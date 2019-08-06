package br.com.gda.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.model.action.LazyPaytusPayordUpdate;
import br.com.gda.payment.statusPayOrder.model.action.StdPaytusMergeMultmoip;
import br.com.gda.payment.statusPayOrder.model.action.StdPaytusSuccess;
import br.com.gda.payment.statusPayOrder.model.checker.PaytusCheckIsFinished;

public final class NodePaytusRefresh extends DeciTreeWriteTemplate<PaytusInfo> {
	
	public NodePaytusRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
		
		checker = new PaytusCheckIsFinished();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> success = new StdPaytusSuccess(option);	
		
		actions.add(success);		
		return actions;
	}	
	
	
	
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnFailedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> mergeMultmoip = new StdPaytusMergeMultmoip(option);	
		ActionLazy<PaytusInfo> payordUpdate = new LazyPaytusPayordUpdate(option.conn, option.schemaName);
		
		mergeMultmoip.addPostAction(payordUpdate);
		
		actions.add(mergeMultmoip);	
		return actions;
	}
}
