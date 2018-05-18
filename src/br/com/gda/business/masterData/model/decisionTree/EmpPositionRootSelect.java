package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.EmpPositionInfo;
import br.com.gda.business.masterData.model.checker.CheckerEmpPositionMandatoryRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpPositionRootSelect implements DeciTree<EmpPositionInfo> {
	private DeciTree<EmpPositionInfo> tree;
	
	
	public EmpPositionRootSelect(DeciTreeOption<EmpPositionInfo> option) {
		DeciTreeHelperOption<EmpPositionInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpPositionInfo> buildDecisionChecker() {
		List<ModelChecker<EmpPositionInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpPositionInfo> checker;
		
		checker = new CheckerEmpPositionMandatoryRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<EmpPositionInfo>> buildActionsOnPassed(DeciTreeOption<EmpPositionInfo> option) {
		List<DeciAction<EmpPositionInfo>> actions = new ArrayList<>();
		
		actions.add(new EmpPositionActionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpPositionInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
