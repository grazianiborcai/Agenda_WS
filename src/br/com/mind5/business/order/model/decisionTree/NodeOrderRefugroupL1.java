package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.StdOrderMergeRefugroup;
import br.com.mind5.business.order.model.action.StdOrderMergeRefupown;
import br.com.mind5.business.order.model.checker.OrderCheckHasRefugroup;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderRefugroupL1 extends DeciTreeTemplateWrite<OrderInfo> {
	
	public NodeOrderRefugroupL1(DeciTreeOption<OrderInfo> option) {
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
		checker = new OrderCheckHasRefugroup(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		

		ActionStd<OrderInfo> mergeRefugroup = new StdOrderMergeRefugroup(option);
		
		actions.add(mergeRefugroup);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		

		ActionStd<OrderInfo> mergeRefupown = new StdOrderMergeRefupown(option);
		
		actions.add(mergeRefupown);
		return actions;
	}
}
