package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusMergePaymoip;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusPayordRefresh;
import br.com.mind5.payment.statusPayOrder.model.action.StdPaytusMergeMultmoip;
import br.com.mind5.payment.statusPayOrder.model.action.StdPaytusSuccess;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckIsFinished;

public final class NodePaytusRefresh extends DeciTreeTemplateWrite<PaytusInfo> {
	
	public NodePaytusRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaytusInfo> buildCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelCheckerV1<PaytusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaytusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusCheckIsFinished(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStdV1<PaytusInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusInfo> success = new StdPaytusSuccess(option);	
		
		actions.add(success);		
		return actions;
	}	
	
	
	
	@Override protected List<ActionStdV1<PaytusInfo>> buildActionsOnFailedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStdV1<PaytusInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusInfo> mergeMultmoip = new StdPaytusMergeMultmoip(option);	
		ActionLazyV1<PaytusInfo> mergePaymoip = new LazyPaytusMergePaymoip(option.conn, option.schemaName);	
		ActionLazyV1<PaytusInfo> payordRefresh = new LazyPaytusPayordRefresh(option.conn, option.schemaName);		
		
		mergeMultmoip.addPostAction(mergePaymoip);
		mergePaymoip.addPostAction(payordRefresh);
		
		actions.add(mergeMultmoip);	
		return actions;
	}
}
