package br.com.gda.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.model.action.StdOrderemSuccess;
import br.com.gda.business.orderItem.model.checker.OrderemCheckIsService;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderemServiceL1 extends DeciTreeWriteTemplate<OrderemInfo> {
	
	public NodeOrderemServiceL1(DeciTreeOption<OrderemInfo> option) {
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
		
		ActionStd<OrderemInfo> nodeL2 = new NodeOrderemServiceL2(option).toAction();
		actions.add(nodeL2);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> success = new StdOrderemSuccess(option);			
		actions.add(success);
		
		return actions;
	}
}
