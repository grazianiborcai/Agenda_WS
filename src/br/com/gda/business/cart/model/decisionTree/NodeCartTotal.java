package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.LazyCartFlagTotal;
import br.com.gda.business.cart.model.action.MultiCartAddTotal;
import br.com.gda.business.cart.model.action.StdCartFlagAll;
import br.com.gda.business.cart.model.action.StdCartMergeTotAmount;
import br.com.gda.business.cart.model.checker.CartCheckDummy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeCartTotal implements DeciTree<CartInfo> {
	private DeciTree<CartInfo> tree;
	
	
	public NodeCartTotal(DeciTreeOption<CartInfo> option) {
		DeciTreeHelperOption<CartInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartInfo> buildDecisionChecker(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();
		ModelChecker<CartInfo> checker;

		checker = new CartCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartInfo>> buildActionsOnPassed(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();
		
		ActionStd<CartInfo> flagAll = new StdCartFlagAll(option);
		ActionLazy<CartInfo> addTotal = new MultiCartAddTotal(option.conn, option.schemaName);
		ActionStd<CartInfo> computeTotal = new StdCartMergeTotAmount(option);
		ActionLazy<CartInfo> flagTotal = new LazyCartFlagTotal(option.conn, option.schemaName);
		
		
		flagAll.addPostAction(addTotal);
		computeTotal.addPostAction(flagTotal);
		flagTotal.addPostAction(addTotal);
		
		
		actions.add(flagAll);
		actions.add(computeTotal);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CartInfo> toAction() {
		return tree.toAction();
	}
}
