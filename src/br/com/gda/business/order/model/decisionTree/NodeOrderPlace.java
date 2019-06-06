package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.checker.OrderCheckPlace;
import br.com.gda.business.order.model.action.LazyOrderRootSelect;
import br.com.gda.business.order.model.action.LazyOrderUpdate;
import br.com.gda.business.order.model.action.StdOrderEnforceStatusWaiting;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderPlace extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderPlace(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		
		checker = new OrderCheckPlace();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> enforceStatus = new StdOrderEnforceStatusWaiting(option);
		ActionLazy<OrderInfo> update = new LazyOrderUpdate(option.conn, option.schemaName);
		ActionLazy<OrderInfo> select = new LazyOrderRootSelect(option.conn, option.schemaName);		
		
		enforceStatus.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(enforceStatus);
		return actions;
	}
}
