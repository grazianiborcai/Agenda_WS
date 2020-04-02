package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
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
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusemCheckIsFinished(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStdV1<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusemInfo> success = new StdPaytusemSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<PaytusemInfo>> buildActionsOnFailedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStdV1<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusemInfo> mergeOrdmoip = new StdPaytusemMergeOrdmoip(option);	
		ActionLazyV1<PaytusemInfo> payordemUpdate = new LazyPaytusemPayordemUpdate(option.conn, option.schemaName);
		
		mergeOrdmoip.addPostAction(payordemUpdate);
		
		actions.add(mergeOrdmoip);		
		return actions;
	}
}
