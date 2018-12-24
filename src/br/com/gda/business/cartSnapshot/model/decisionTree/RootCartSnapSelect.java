package br.com.gda.business.cartSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapMergeCartCateg;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapNodeSelectItem;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapNodeSelectTotal;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapNodeSelectFee;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapSort;
import br.com.gda.business.cartSnapshot.model.action.MultiCartSnapJoinResult;
import br.com.gda.business.cartSnapshot.model.action.StdCartSnapSelect;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckRead;
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

public final class RootCartSnapSelect implements DeciTree<CartSnapInfo> {
	private DeciTree<CartSnapInfo> tree;
	
	
	public RootCartSnapSelect(DeciTreeOption<CartSnapInfo> option) {
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
		
		checker = new CartSnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<CartSnapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<CartSnapInfo>> buildActionsOnPassed(DeciTreeOption<CartSnapInfo> option) {
		List<ActionStd<CartSnapInfo>> actions = new ArrayList<>();
		//TODO: Store nao vem do Snapshot
		ActionStd<CartSnapInfo> select = new StdCartSnapSelect(option);
		ActionLazy<CartSnapInfo> selectItem = new LazyCartSnapNodeSelectItem(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> selectFee = new LazyCartSnapNodeSelectFee(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> selectTotal = new LazyCartSnapNodeSelectTotal(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> joinResult = new MultiCartSnapJoinResult(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> mergeCartCateg = new LazyCartSnapMergeCartCateg(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> sort = new LazyCartSnapSort(option.conn, option.schemaName);
		
		select.addPostAction(selectItem);
		selectItem.addPostAction(joinResult);
		
		select.addPostAction(selectFee);
		selectFee.addPostAction(joinResult);
		
		select.addPostAction(selectTotal);
		selectTotal.addPostAction(joinResult);
		
		joinResult.addPostAction(mergeCartCateg);
		mergeCartCateg.addPostAction(sort);
		
		actions.add(select); 
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
