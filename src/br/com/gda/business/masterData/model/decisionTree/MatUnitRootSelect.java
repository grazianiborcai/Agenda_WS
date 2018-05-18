package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.checker.CheckerMatUnitMandatoryRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatUnitRootSelect implements DeciTree<MatUnitInfo> {
	private DeciTree<MatUnitInfo> tree;
	
	
	public MatUnitRootSelect(DeciTreeOption<MatUnitInfo> option) {
		DeciTreeHelperOption<MatUnitInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatUnitInfo> buildDecisionChecker() {
		List<ModelChecker<MatUnitInfo>> stack = new ArrayList<>();		
		ModelChecker<MatUnitInfo> checker;
		
		checker = new CheckerMatUnitMandatoryRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<MatUnitInfo>> buildActionsOnPassed(DeciTreeOption<MatUnitInfo> option) {
		List<DeciAction<MatUnitInfo>> actions = new ArrayList<>();
		
		actions.add(new MatUnitActionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatUnitInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
