package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderNodeUpdate;
import br.com.mind5.business.order.model.action.StdOrderEnforceStatusRefunding;
import br.com.mind5.business.order.model.checker.OrderCheckRefundingStatus;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderRefunding extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderRefunding(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		
		checker = new OrderCheckRefundingStatus();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> enforceStatus = new StdOrderEnforceStatusRefunding(option);
		ActionLazy<OrderInfo> update = new LazyOrderNodeUpdate(option.conn, option.schemaName);		
		
		enforceStatus.addPostAction(update);
		
		actions.add(enforceStatus);
		return actions;
	}
}
