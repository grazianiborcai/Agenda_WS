package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.checker.CartCheckDelete;
import br.com.gda.business.cart.model.checker.CartCheckExistItm;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class RootCartDeleteItm implements DeciTree<CartInfo> {
	private DeciTree<CartInfo> tree;
	
	
	public RootCartDeleteItm(DeciTreeOption<CartInfo> option) {
		DeciTreeHelperOption<CartInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartInfo> buildDecisionChecker(DeciTreeOption<CartInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartCheckDelete();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckExistItm(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<CartInfo>> buildActionsOnPassed(DeciTreeOption<CartInfo> option) {
		List<DeciAction<CartInfo>> actions = new ArrayList<>();		
		
		DeciAction<CartInfo> selectItem = new ActionCartSelect(option);
		DeciActionHandler<CartInfo> deleteItm = new HandlerCartDeleteItm(option.conn, option.schemaName);
		
		selectItem.addPostAction(deleteItm);
		
		actions.add(selectItem);		
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
	
	
	
	@Override public DeciAction<CartInfo> toAction() {
		return tree.toAction();
	}
}
