package br.com.gda.business.cartSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapNodeInsertL2;
import br.com.gda.business.cartSnapshot.model.action.StdCartSnapMergeSnap;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckHasSnap;
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

public final class NodeCartSnapInsertL1 implements DeciTree<CartSnapInfo> {
	private DeciTree<CartSnapInfo> tree;
	
	
	public NodeCartSnapInsertL1(DeciTreeOption<CartSnapInfo> option) {
		DeciTreeHelperOption<CartSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartSnapInfo> buildDecisionChecker(DeciTreeOption<CartSnapInfo> option) {
		List<ModelChecker<CartSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CartSnapInfo> checker;	
		
		checker = new CartSnapCheckHasSnap();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartSnapInfo>> buildActionsOnPassed(DeciTreeOption<CartSnapInfo> option) {
		List<ActionStd<CartSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartSnapInfo> nodeL2 = new NodeCartSnapInsertL2(option).toAction();	
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	private List<ActionStd<CartSnapInfo>> buildActionsOnFailed(DeciTreeOption<CartSnapInfo> option) {
		List<ActionStd<CartSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartSnapInfo> mergeSnap = new StdCartSnapMergeSnap(option);	
		ActionLazy<CartSnapInfo> nodeL2 = new LazyCartSnapNodeInsertL2(option.conn, option.schemaName);	
		
		mergeSnap.addPostAction(nodeL2);
		
		actions.add(mergeSnap);
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
