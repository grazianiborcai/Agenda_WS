package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderEnforceStatusMoip;
import br.com.gda.business.order.model.action.StdOrderMergePayord;
import br.com.gda.business.order.model.action.StdOrderSuccess;
import br.com.gda.business.order.model.checker.OrderCheckHasPayord;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderPayord extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderPayord(DeciTreeOption<OrderInfo> option) {
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

		ActionStd<OrderInfo> mergePayord = new StdOrderMergePayord(option);
		ActionLazy<OrderInfo> enforceStatus = new LazyOrderEnforceStatusMoip(option.conn, option.schemaName);
		
		mergePayord.addPostAction(enforceStatus);
		
		actions.add(mergePayord);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		

		ActionStd<OrderInfo> success = new StdOrderSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
