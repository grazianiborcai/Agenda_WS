package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.OrderVisiNodeUpdate;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrderem;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrdugePay;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderNodePay extends DeciTreeTemplateWrite<OrderInfo> {
	
	public OrderNodePay(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> statusChange = new ActionStdCommom<OrderInfo>(option, OrderVisiMergeOrdugePay.class);
		ActionLazy<OrderInfo> update = new ActionLazyCommom<OrderInfo>(option, OrderVisiNodeUpdate.class);	
		ActionLazy<OrderInfo> mergeOrderem = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeOrderem.class);
		
		statusChange.addPostAction(update);
		update.addPostAction(mergeOrderem);
		
		actions.add(statusChange);
		return actions;
	}
}
