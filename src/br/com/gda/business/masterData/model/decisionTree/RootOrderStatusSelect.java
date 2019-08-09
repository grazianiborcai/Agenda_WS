package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.model.action.StdOrderStatusSelect;
import br.com.gda.business.masterData.model.checker.OrderStatusCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootOrderStatusSelect extends DeciTreeReadTemplate<OrderStatusInfo> {
	
	public RootOrderStatusSelect(DeciTreeOption<OrderStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderStatusInfo> buildDecisionCheckerHook(DeciTreeOption<OrderStatusInfo> option) {
		List<ModelChecker<OrderStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderStatusInfo> checker;
		
		checker = new OrderStatusCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<OrderStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderStatusInfo> option) {
		List<ActionStd<OrderStatusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdOrderStatusSelect(option));
		return actions;
	}
}
