package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.CheckerStoreCnpj;
import br.com.gda.business.store.model.checker.CheckerStoreMandatoryRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;


public final class StoreRootSelect implements DecisionTree<StoreInfo> {
	private DecisionTree<StoreInfo> tree;
	
	
	public StoreRootSelect(DecisionTreeOption<StoreInfo> option) {
		DecisionTreeHelperOption<StoreInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker() {
		List<ModelChecker<StoreInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		
		checker = new CheckerStoreMandatoryRead();
		stack.add(checker);
		
		checker = new CheckerStoreCnpj();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<StoreInfo>> buildActionsOnPassed(DecisionTreeOption<StoreInfo> option) {
		List<DecisionAction<StoreInfo>> actions = new ArrayList<>();
		
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
