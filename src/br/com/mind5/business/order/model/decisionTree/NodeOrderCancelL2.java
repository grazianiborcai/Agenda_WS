package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderNodeUpdate;
import br.com.mind5.business.order.model.action.StdOrderEnforceStatusCancelled;
import br.com.mind5.business.order.model.action.StdOrderRefuRefund;
import br.com.mind5.business.order.model.checker.OrderCheckHasPayord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderCancelL2 extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderCancelL2(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		
		checker = new OrderCheckHasPayord();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> refundOrder = new StdOrderRefuRefund(option);
		
		actions.add(refundOrder);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> enforceStatus = new StdOrderEnforceStatusCancelled(option);
		ActionLazy<OrderInfo> update = new LazyOrderNodeUpdate(option.conn, option.schemaName);
		
		enforceStatus.addPostAction(update);
		
		actions.add(enforceStatus);
		return actions;
	}
}
