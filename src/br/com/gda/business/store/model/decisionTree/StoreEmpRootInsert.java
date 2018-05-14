package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.checker.CheckerStoreEmpDependencyOnDb;
import br.com.gda.business.store.model.checker.CheckerStoreEmpExistOnDb;
import br.com.gda.business.store.model.checker.CheckerStoreEmpMandatoryWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class StoreEmpRootInsert implements DecisionTree<StoreEmpInfo> {
	private DecisionTree<StoreEmpInfo> tree;
	
	
	public StoreEmpRootInsert(DecisionTreeOption<StoreEmpInfo> option) {
		DecisionTreeHelperOption<StoreEmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DecisionTreeOption<StoreEmpInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<StoreEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerStoreEmpMandatoryWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CheckerStoreEmpExistOnDb(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerStoreEmpDependencyOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<StoreEmpInfo>> buildActionsOnPassed(DecisionTreeOption<StoreEmpInfo> option) {
		List<DecisionAction<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionNodeInsert(option));	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<StoreEmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
	
	
	private static class ActionNodeInsert implements DecisionAction<StoreEmpInfo> {
		DecisionTree<StoreEmpInfo> treeHelper;
		
		
		public ActionNodeInsert(DecisionTreeOption<StoreEmpInfo> option) {
			treeHelper = new StoreEmpNodeInsert(option);
		}
		
		
		
		@Override public boolean executeAction() {			
			  treeHelper.makeDecision();
			  DecisionResult<StoreEmpInfo> treeResult = treeHelper.getDecisionResult();
			  return treeResult.hasSuccessfullyFinished();
		}
		
		
		
		@Override public DecisionResult<StoreEmpInfo> getDecisionResult() {
			return treeHelper.getDecisionResult();
		}
	}
}
