package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderDeleteCart;
import br.com.gda.business.order.model.action.LazyOrderEnforceExtid;
import br.com.gda.business.order.model.action.LazyOrderEnforceLChanged;
import br.com.gda.business.order.model.action.LazyOrderInsert;
import br.com.gda.business.order.model.action.LazyOrderMergeUserSnap;
import br.com.gda.business.order.model.checker.OrderCheckCart;
import br.com.gda.business.order.model.checker.OrderCheckUser;
import br.com.gda.business.order.model.checker.OrderCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootOrderPlace implements DeciTree<OrderInfo> {
	private DeciTree<OrderInfo> tree;
	
	
	public RootOrderPlace(DeciTreeOption<OrderInfo> option) {
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
		
		checker = new OrderCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckCart(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<OrderInfo>> buildActionsOnPassed(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrderInfo> nodeSnapshot = new NodeOrderSnapshot(option).toAction();
		ActionLazy<OrderInfo> enforceLChanged = new LazyOrderEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceExtid = new LazyOrderEnforceExtid(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeUserSnap = new LazyOrderMergeUserSnap(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insertOrder = new LazyOrderInsert(option.conn, option.schemaName);
		ActionLazy<OrderInfo> emptyCart = new LazyOrderDeleteCart(option.conn, option.schemaName);
		
		nodeSnapshot.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceExtid);
		enforceExtid.addPostAction(mergeUserSnap);
		mergeUserSnap.addPostAction(insertOrder);
		insertOrder.addPostAction(emptyCart);
		
		actions.add(nodeSnapshot);
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
	
	
	
	@Override public ActionStd<OrderInfo> toAction() {
		return tree.toAction();
	}
}
