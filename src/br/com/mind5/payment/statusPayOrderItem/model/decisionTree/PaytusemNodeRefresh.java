package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.action.PaytusemVisiMergeOrdmoip;
import br.com.mind5.payment.statusPayOrderItem.model.action.PaytusemVisiPayordemUpdate;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckIsFinished;

public final class PaytusemNodeRefresh extends DeciTreeTemplateWrite<PaytusemInfo> {
	
	public PaytusemNodeRefresh(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusemInfo> buildCheckerHook(DeciTreeOption<PaytusemInfo> option) {		
		List<ModelChecker<PaytusemInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusemCheckIsFinished(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> success = new ActionStdSuccessCommom<PaytusemInfo>(option);	
		
		actions.add(success);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnFailedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd <PaytusemInfo> mergeOrdmoip   = new ActionStdCommom <PaytusemInfo>(option, PaytusemVisiMergeOrdmoip.class);
		ActionLazy<PaytusemInfo> payordemUpdate = new ActionLazyCommom<PaytusemInfo>(option, PaytusemVisiPayordemUpdate.class);
		
		mergeOrdmoip.addPostAction(payordemUpdate);
		
		actions.add(mergeOrdmoip);		
		return actions;
	}
}
