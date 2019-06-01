package br.com.gda.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.business.orderItem.model.action.LazyOrderMergeCartSnap;
import br.com.gda.business.orderItem.model.action.LazyOrderMergeOrderStatus;
import br.com.gda.business.orderItem.model.action.StdOrderSelect;
import br.com.gda.business.orderItem.model.checker.OrderCheckLangu;
import br.com.gda.business.orderItem.model.checker.OrderCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
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
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OrderInfo> buildDecisionChecker(DeciTreeOption<OrderInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckLangu(checkerOption);
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
		ActionLazy<OrderInfo> mergeOrderStatus = new LazyOrderMergeOrderStatus(option.conn, option.schemaName);
		
		select.addPostAction(mergeCartSnap);
		mergeCartSnap.addPostAction(mergeOrderStatus);
		
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
