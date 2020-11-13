package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.action.LazyPaytusemPayordemUpdate;
import br.com.mind5.payment.statusPayOrderItem.model.action.StdPaytusemMergeOrdmoip;
import br.com.mind5.payment.statusPayOrderItem.model.action.StdPaytusemSuccess;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckIsFinished;

public final class NodePaytusemRefresh extends DeciTreeTemplateWriteV2<PaytusemInfo> {
	
	public NodePaytusemRefresh(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaytusemInfo> buildCheckerHook(DeciTreeOption<PaytusemInfo> option) {		
		List<ModelCheckerV1<PaytusemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaytusemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusemCheckIsFinished(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStdV2<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStdV2<PaytusemInfo> success = new StdPaytusemSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<PaytusemInfo>> buildActionsOnFailedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStdV2<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStdV2<PaytusemInfo> mergeOrdmoip = new StdPaytusemMergeOrdmoip(option);	
		ActionLazy<PaytusemInfo> payordemUpdate = new LazyPaytusemPayordemUpdate(option.conn, option.schemaName);
		
		mergeOrdmoip.addPostAction(payordemUpdate);
		
		actions.add(mergeOrdmoip);		
		return actions;
	}
}
