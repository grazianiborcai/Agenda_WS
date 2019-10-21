package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.model.action.StdOrderStatusSelect;
import br.com.mind5.business.masterData.model.checker.OrderStatusCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
