package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderMergeCartSnap;
import br.com.gda.business.order.model.action.StdOrderSelect;
import br.com.gda.business.order.model.checker.OrderCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootOrderSelect implements DeciTree<OrderInfo> {
	private DeciTree<OrderInfo> tree;
	
	
	public RootOrderSelect(DeciTreeOption<OrderInfo> option) {
		DeciTreeHelperOption<OrderInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OrderInfo> buildDecisionChecker() {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;
		
		checker = new OrderCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<OrderInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<OrderInfo>> buildActionsOnPassed(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> select = new StdOrderSelect(option);
		ActionLazy<OrderInfo> mergeCartSnap = new LazyOrderMergeCartSnap(option.conn, option.schemaName);
		
		select.addPostAction(mergeCartSnap);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OrderInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
