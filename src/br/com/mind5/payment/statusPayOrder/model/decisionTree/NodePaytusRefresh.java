package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
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
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusCheckIsFinished(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
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
		ActionLazy<PaytusInfo> mergePaymoip = new LazyPaytusMergePaymoip(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> payordRefresh = new LazyPaytusPayordRefresh(option.conn, option.schemaName);		
		
		mergeMultmoip.addPostAction(mergePaymoip);
		mergePaymoip.addPostAction(payordRefresh);
		
		actions.add(mergeMultmoip);	
		return actions;
	}
}
