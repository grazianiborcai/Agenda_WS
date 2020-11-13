package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrdugePartner;
import br.com.mind5.business.order.model.action.StdOrderMergePayord;
import br.com.mind5.business.order.model.action.StdOrderSuccess;
import br.com.mind5.business.order.model.checker.OrderCheckHasPayord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderPayord extends DeciTreeTemplateWrite<OrderInfo> {
	
	public NodeOrderPayord(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderCheckHasPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		

		ActionStd<OrderInfo> mergePayord = new StdOrderMergePayord(option);
		ActionLazy<OrderInfo> statusChange = new LazyOrderMergeOrdugePartner(option.conn, option.schemaName);
		
		mergePayord.addPostAction(statusChange);
		
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
