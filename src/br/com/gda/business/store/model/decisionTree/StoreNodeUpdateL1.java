package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.CheckerStoreConstraintOnDb;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreNodeUpdateL1 implements DeciTree<StoreInfo> {
	private DeciTree<StoreInfo> tree;
	
	
	public StoreNodeUpdateL1(DeciTreeOption<StoreInfo> option) {
		DeciTreeHelperOption<StoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.schemaName = option.schemaName;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DeciTreeOption<StoreInfo> option) {
		final boolean EXIST_WITH_CONSTRAINT_ON_DB = true;
		
		List<ModelChecker<StoreInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_WITH_CONSTRAINT_ON_DB;		
		checker = new CheckerStoreConstraintOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<StoreInfo>> buildActionsOnPassed(DeciTreeOption<StoreInfo> option) {
		List<DeciAction<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StoreActionUpdate(option));
		actions.add(new StoreActionSelect(option));		
		return actions;
	}
	
	
	
	private List<DeciAction<StoreInfo>> buildActionsOnFailed(DeciTreeOption<StoreInfo> option) {
		List<DeciAction<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionNodeUpdateL2(option));	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	private static class ActionNodeUpdateL2 implements DeciAction<StoreInfo> {
		DeciTree<StoreInfo> treeHelper;
		
		
		public ActionNodeUpdateL2(DeciTreeOption<StoreInfo> option) {
			treeHelper = new StoreNodeUpdateL2(option);
		}
		
		
		
		@Override public boolean executeAction() {			
			  treeHelper.makeDecision();
			  DeciResult<StoreInfo> treeResult = treeHelper.getDecisionResult();
			  return treeResult.hasSuccessfullyFinished();
		}
		
		
		
		@Override public DeciResult<StoreInfo> getDecisionResult() {
			return treeHelper.getDecisionResult();
		}
	}
}
