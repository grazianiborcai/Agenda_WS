package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.action.LazyPaytusemPayordemUpdate;
import br.com.mind5.payment.statusPayOrderItem.model.action.StdPaytusemMergeOrdmoip;
import br.com.mind5.payment.statusPayOrderItem.model.action.StdPaytusemSuccess;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckIsFinished;

public final class NodePaytusemRefresh extends DeciTreeWriteTemplate<PaytusemInfo> {
	
	public NodePaytusemRefresh(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusemInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusemInfo> option) {		
		List<ModelChecker<PaytusemInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusemInfo> checker;	
		
		checker = new PaytusemCheckIsFinished();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> success = new StdPaytusemSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnFailedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> mergeOrdmoip = new StdPaytusemMergeOrdmoip(option);	
		ActionLazy<PaytusemInfo> payordemUpdate = new LazyPaytusemPayordemUpdate(option.conn, option.schemaName);
		
		mergeOrdmoip.addPostAction(payordemUpdate);
		
		actions.add(mergeOrdmoip);		
		return actions;
	}
}
