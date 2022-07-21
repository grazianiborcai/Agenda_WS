package br.com.mind5.payment.payOrderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.action.PayormarchVisiRootSelect;
import br.com.mind5.payment.payOrderItemSearch.model.action.PayormarchVisiEnforceReverted;

public final class PayormarchRootSelectReverted extends DeciTreeTemplateWrite<PayormarchInfo> {
	
	public PayormarchRootSelectReverted(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayormarchInfo> buildCheckerHook(DeciTreeOption<PayormarchInfo> option) {
		List<ModelChecker<PayormarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PayormarchInfo> checker;	

		checker = new ModelCheckerDummy<PayormarchInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayormarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayormarchInfo> option) {
		List<ActionStd<PayormarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PayormarchInfo> enforceReverted = new ActionStdCommom<PayormarchInfo>(option, PayormarchVisiEnforceReverted.class);
		ActionLazy<PayormarchInfo> select = new ActionLazyCommom<PayormarchInfo>(option, PayormarchVisiRootSelect.class);
		
		enforceReverted.addPostAction(select);
		
		actions.add(enforceReverted);
		return actions;
	}
}
