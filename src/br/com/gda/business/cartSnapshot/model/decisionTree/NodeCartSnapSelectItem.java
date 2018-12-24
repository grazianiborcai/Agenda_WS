package br.com.gda.business.cartSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapEnforceWeekday;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapFlagItem;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapMergeCartCateg;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapMergeMatSnap;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapMergeStore;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapMergeWeekday;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapSort;
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

public final class NodeCartSnapSelectItem implements DeciTree<CartSnapInfo> {
	private DeciTree<CartSnapInfo> tree;
	
	
	public NodeCartSnapSelectItem(DeciTreeOption<CartSnapInfo> option) {
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
		//TODO: Store nao vem do Snapshot
		ActionStd<CartSnapInfo> filterItem = new StdCartSnapFilterCategItem(option);
		ActionLazy<CartSnapInfo> flagItem = new LazyCartSnapFlagItem(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> mergeMat = new LazyCartSnapMergeMatSnap(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> mergeStore = new LazyCartSnapMergeStore(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> enforceWeekday = new LazyCartSnapEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> mergeWeekday = new LazyCartSnapMergeWeekday(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> mergeCartCateg = new LazyCartSnapMergeCartCateg(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> sort = new LazyCartSnapSort(option.conn, option.schemaName);
		
		filterItem.addPostAction(mergeMat);
		mergeMat.addPostAction(flagItem);
		flagItem.addPostAction(mergeStore);
		mergeStore.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeCartCateg);
		mergeCartCateg.addPostAction(sort);
		
		actions.add(filterItem); 
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
