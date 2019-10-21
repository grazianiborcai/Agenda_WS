package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckIsService;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderemSelect extends DeciTreeWriteTemplate<OrderemInfo> {
	
	public NodeOrderemSelect(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildDecisionCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;
		
		checker = new OrderemCheckIsService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> selectService = new NodeOrderemSelectService(option).toAction();
		
		actions.add(selectService);
		return actions;
	}
}
