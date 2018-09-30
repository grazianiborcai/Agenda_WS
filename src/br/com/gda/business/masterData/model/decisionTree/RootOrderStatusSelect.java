package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.model.checker.OrderStatusCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootOrderStatusSelect implements DeciTree<OrderStatusInfo> {
	private DeciTree<OrderStatusInfo> tree;
	
	
	public RootOrderStatusSelect(DeciTreeOption<OrderStatusInfo> option) {
		DeciTreeHelperOption<OrderStatusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OrderStatusInfo> buildDecisionChecker() {
		List<ModelChecker<OrderStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderStatusInfo> checker;
		
		checker = new OrderStatusCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<DeciAction<OrderStatusInfo>> buildActionsOnPassed(DeciTreeOption<OrderStatusInfo> option) {
		List<DeciAction<OrderStatusInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionOrderStatusSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OrderStatusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<OrderStatusInfo> toAction() {
		return tree.toAction();
	}
}
