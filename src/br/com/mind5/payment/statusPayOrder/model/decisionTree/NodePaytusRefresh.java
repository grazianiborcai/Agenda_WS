package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusMergePaymoip;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusPayordRefresh;
import br.com.mind5.payment.statusPayOrder.model.action.StdPaytusMergeMultmoip;
import br.com.mind5.payment.statusPayOrder.model.action.StdPaytusSuccess;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckIsFinished;

public final class NodePaytusRefresh extends DeciTreeWriteTemplate<PaytusInfo> {
	
	public NodePaytusRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusCheckIsFinished(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
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
