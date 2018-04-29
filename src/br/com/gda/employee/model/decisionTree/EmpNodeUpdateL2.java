package br.com.gda.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpInfo;
import br.com.gda.employee.model.checker.CheckerEmpCpfExistOnDb;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class EmpNodeUpdateL2 implements DecisionTree<EmpInfo> {
	private DecisionTree<EmpInfo> tree;
	
	
	public EmpNodeUpdateL2(DecisionTreeOption<EmpInfo> option) {
		DecisionTreeHelperOption<EmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.schemaName = option.schemaName;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DecisionTreeOption<EmpInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CheckerEmpCpfExistOnDb(checkerOption);
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<EmpInfo>> buildActionsOnPassed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionActionAdapter<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new EmpActionUpdate(option));
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
