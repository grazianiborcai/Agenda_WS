package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.CheckerStoreCnpjExistOnDb;
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

final class StoreNodeUpdateL2 implements DecisionTree<StoreInfo> {
	private DecisionTree<StoreInfo> tree;
	
	
	public StoreNodeUpdateL2(DecisionTreeOption<StoreInfo> option) {
		DecisionTreeHelperOption<StoreInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.schemaName = option.schemaName;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DecisionTreeOption<StoreInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<StoreInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CheckerStoreCnpjExistOnDb(checkerOption);
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<StoreInfo>> buildActionsOnPassed(DecisionTreeOption<StoreInfo> option) {
		List<DecisionAction<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StoreActionUpdate(option));
		actions.add(new StoreActionSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<StoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
