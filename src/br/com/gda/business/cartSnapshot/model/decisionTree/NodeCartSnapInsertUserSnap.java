package br.com.gda.business.cartSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapFirstRow;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapInsertUserSnap;
import br.com.gda.business.cartSnapshot.model.action.StdCartSnapFilterCategItem;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckDummy;
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

public final class NodeCartSnapInsertUserSnap implements DeciTree<CartSnapInfo> {
	private DeciTree<CartSnapInfo> tree;
	
	
	public NodeCartSnapInsertUserSnap(DeciTreeOption<CartSnapInfo> option) {
		DeciTreeHelperOption<CartSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartSnapInfo> buildDecisionChecker(DeciTreeOption<CartSnapInfo> option) {
		List<ModelChecker<CartSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CartSnapInfo> checker;	
		
		checker = new CartSnapCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartSnapInfo>> buildActionsOnPassed(DeciTreeOption<CartSnapInfo> option) {

		
		
		List<ActionStd<CartSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartSnapInfo> filterCategItem = new StdCartSnapFilterCategItem(option);	
		ActionLazy<CartSnapInfo> firstRow = new LazyCartSnapFirstRow(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> insertUserSnap = new LazyCartSnapInsertUserSnap(option.conn, option.schemaName);
		
		filterCategItem.addPostAction(firstRow);
		firstRow.addPostAction(insertUserSnap);
		
		actions.add(filterCategItem);
		return actions;
	}	
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CartSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CartSnapInfo> toAction() {
		return tree.toAction();
	}
}
