package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.checker.CheckerStoreEmpMandatoryRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class StoreEmpRootSelect implements DecisionTree<StoreEmpInfo> {
	private DecisionTree<StoreEmpInfo> tree;
	
	
	public StoreEmpRootSelect(DecisionTreeOption<StoreEmpInfo> option) {
		DecisionTreeHelperOption<StoreEmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker() {
		List<ModelChecker<StoreEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		
		checker = new CheckerStoreEmpMandatoryRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<StoreEmpInfo>> buildActionsOnPassed(DecisionTreeOption<StoreEmpInfo> option) {
		List<DecisionActionAdapter<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StoreEmpActionSelect(option));
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
}
