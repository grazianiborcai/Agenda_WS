package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.CheckerEmpCpf;
import br.com.gda.business.employee.model.checker.CheckerEmpMandatoryRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class EmpRootSelect implements DecisionTree<EmpInfo> {
	private DecisionTree<EmpInfo> tree;
	
	
	public EmpRootSelect(DecisionTreeOption<EmpInfo> option) {
		DecisionTreeHelperOption<EmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker() {
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		
		checker = new CheckerEmpMandatoryRead();
		stack.add(checker);
		
		checker = new CheckerEmpCpf();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<EmpInfo>> buildActionsOnPassed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionAction<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new EmpActionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<EmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
