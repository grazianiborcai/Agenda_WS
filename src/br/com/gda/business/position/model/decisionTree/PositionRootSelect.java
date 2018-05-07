package br.com.gda.business.position.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.position.info.PositionInfo;
import br.com.gda.business.position.model.checker.CheckerPositionMandatoryRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class PositionRootSelect implements DecisionTree<PositionInfo> {
	private DecisionTree<PositionInfo> tree;
	
	
	public PositionRootSelect(DecisionTreeOption<PositionInfo> option) {
		DecisionTreeHelperOption<PositionInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PositionInfo> buildDecisionChecker() {
		List<ModelChecker<PositionInfo>> stack = new ArrayList<>();		
		ModelChecker<PositionInfo> checker;
		
		checker = new CheckerPositionMandatoryRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<PositionInfo>> buildActionsOnPassed(DecisionTreeOption<PositionInfo> option) {
		List<DecisionActionAdapter<PositionInfo>> actions = new ArrayList<>();
		
		actions.add(new PositionActionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<PositionInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
