package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.checker.CartCheckRead;
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

public final class RootCartSelect implements DeciTree<CartInfo> {
	private DeciTree<CartInfo> tree;
	
	
	public RootCartSelect(DeciTreeOption<CartInfo> option) {
		DeciTreeHelperOption<CartInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartInfo> buildDecisionChecker(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		
		checker = new CartCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartInfo>> buildActionsOnPassed(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();		
		
		ActionStd<CartInfo> selectCart = new ActionCartSelect(option);
		ActionLazy<CartInfo> enforceCateg = new HandlerCartEnforceCateg(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeStore = new HandlerCartMergeStore(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceWeekday = new HandlerCartEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeWeekday = new HandlerCartMergeWeekday(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeCateg = new HandlerCartMergeCateg(option.conn, option.schemaName);
		ActionLazy<CartInfo> addFee = new HandlerCartFee(option.conn, option.schemaName);
		ActionLazy<CartInfo> addTotal = new HandlerCartTotal(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeMat = new HandlerCartMergeMat(option.conn, option.schemaName);
		
		selectCart.addPostAction(mergeMat);
		mergeMat.addPostAction(mergeStore);
		mergeStore.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(enforceCateg);
		enforceCateg.addPostAction(addFee);
		addFee.addPostAction(addTotal);
		addTotal.addPostAction(mergeCateg);
		
		actions.add(selectCart);	
		
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
