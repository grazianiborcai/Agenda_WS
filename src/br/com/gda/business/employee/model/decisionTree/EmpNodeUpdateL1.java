package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.CheckerEmpConstraintOnDb;
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

final class EmpNodeUpdateL1 implements DecisionTree<EmpInfo> {
	private DecisionTree<EmpInfo> tree;
	
	
	public EmpNodeUpdateL1(DecisionTreeOption<EmpInfo> option) {
		DecisionTreeHelperOption<EmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.schemaName = option.schemaName;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DecisionTreeOption<EmpInfo> option) {
		final boolean EXIST_WITH_CONSTRAINT_ON_DB = true;
		
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_WITH_CONSTRAINT_ON_DB;		
		checker = new CheckerEmpConstraintOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<EmpInfo>> buildActionsOnPassed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionAction<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new EmpActionUpdate(option));
		actions.add(new EmpActionSelect(option));		
		return actions;
	}
	
	
	
	private List<DecisionAction<EmpInfo>> buildActionsOnFailed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionAction<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionNodeUpdate(option));	
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
	
	
	
	private static class ActionNodeUpdate implements DecisionAction<EmpInfo> {
		EmpNodeUpdateL2 treeHelper;
		
		
		public ActionNodeUpdate(DecisionTreeOption<EmpInfo> option) {
			treeHelper = new EmpNodeUpdateL2(option);
		}
		
		
		
		@Override public boolean executeAction() {			
			  treeHelper.makeDecision();
			  DecisionResult<EmpInfo> treeResult = treeHelper.getDecisionResult();
			  return treeResult.hasSuccessfullyFinished();
		}
		
		
		
		@Override public DecisionResult<EmpInfo> getDecisionResult() {
			return treeHelper.getDecisionResult();
		}
	}
}
