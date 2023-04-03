package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.PaytusVisiMergeMultmoip;
import br.com.mind5.payment.statusPayOrder.model.action.PaytusVisiMergePaymoip;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckIsMoip;

public final class PaytusNodeRefreshL3 extends DeciTreeTemplateWrite<PaytusInfo> {
	
	public PaytusNodeRefreshL3(DeciTreeOption<PaytusInfo> option) {
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
		checker = new PaytusCheckIsMoip(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd <PaytusInfo> mergeMultmoip = new ActionStdCommom <PaytusInfo>(option, PaytusVisiMergeMultmoip.class);
		ActionLazy<PaytusInfo> mergePaymoip  = new ActionLazyCommom<PaytusInfo>(option, PaytusVisiMergePaymoip.class);
		
		mergeMultmoip.addPostAction(mergePaymoip);
		
		actions.add(mergeMultmoip);	
		return actions;
	}
}
