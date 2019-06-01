package br.com.gda.business.cartSnapshot_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot_.model.action.LazyCartSnapFlagTotal;
import br.com.gda.business.cartSnapshot_.model.action.LazyCartSnapMergeCurrency;
import br.com.gda.business.cartSnapshot_.model.action.StdCartSnapFilterCategTotal;
import br.com.gda.business.cartSnapshot_.model.checker.CartSnapCheckDummy;
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

public final class NodeCartSnapSelectTotal implements DeciTree<CartSnapInfo> {
	private DeciTree<CartSnapInfo> tree;
	
	
	public NodeCartSnapSelectTotal(DeciTreeOption<CartSnapInfo> option) {
		DeciTreeHelperOption<CartSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartSnapInfo> buildDecisionChecker() {
		List<ModelChecker<CartSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CartSnapInfo> checker;
		
		checker = new CartSnapCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<CartSnapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<CartSnapInfo>> buildActionsOnPassed(DeciTreeOption<CartSnapInfo> option) {
		List<ActionStd<CartSnapInfo>> actions = new ArrayList<>();

		ActionStd<CartSnapInfo> filterTotal = new StdCartSnapFilterCategTotal(option);
		ActionLazy<CartSnapInfo> flagTotal = new LazyCartSnapFlagTotal(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> mergeCurrency = new LazyCartSnapMergeCurrency(option.conn, option.schemaName);		
		
		filterTotal.addPostAction(flagTotal);
		flagTotal.addPostAction(mergeCurrency);
		
		actions.add(filterTotal); 
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
}
