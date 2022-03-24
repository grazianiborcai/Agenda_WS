package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.OrderVisiNodeUpdate;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrderem;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrdugePlace;
import br.com.mind5.business.order.model.action.OrderVisiOrderemPlace;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderNodePlace extends DeciTreeTemplateWrite<OrderInfo> {
	
	public OrderNodePlace(DeciTreeOption<OrderInfo> option) {
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
		
		ActionStd<OrderInfo> enforceStatus = new ActionStdCommom<OrderInfo>(option, OrderVisiMergeOrdugePlace.class);
		ActionLazy<OrderInfo> update = new ActionLazyCommom<OrderInfo>(option, OrderVisiNodeUpdate.class);
		ActionLazy<OrderInfo> mergeOrderem = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeOrderem.class);
		ActionLazy<OrderInfo> placeOrderem = new ActionLazyCommom<OrderInfo>(option, OrderVisiOrderemPlace.class);
		
		enforceStatus.addPostAction(update);
		update.addPostAction(mergeOrderem);
		mergeOrderem.addPostAction(placeOrderem);
		
		actions.add(enforceStatus);
		return actions;
	}
}
