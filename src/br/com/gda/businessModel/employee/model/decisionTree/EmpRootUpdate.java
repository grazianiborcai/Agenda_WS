package br.com.gda.businessModel.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.businessModel.employee.info.EmpInfo;
import br.com.gda.businessModel.employee.model.checker.CheckerEmpCpf;
import br.com.gda.businessModel.employee.model.checker.CheckerEmpExistOnDb;
import br.com.gda.businessModel.employee.model.checker.CheckerEmpMandatoryKey;
import br.com.gda.businessModel.employee.model.checker.CheckerEmpMandatoryWrite;
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

public final class EmpRootUpdate implements DecisionTree<EmpInfo> {
	private DecisionTree<EmpInfo> tree;
	
	
	public EmpRootUpdate(DecisionTreeOption<EmpInfo> option) {
		DecisionTreeHelperOption<EmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DecisionTreeOption<EmpInfo> option) {
		final boolean EXIST_ON_DB = true;			
		final boolean KEY_NOT_NULL = true;	
		
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerEmpMandatoryWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;
		checker = new CheckerEmpMandatoryKey(checkerOption);
		stack.add(checker);
		
		checker = new CheckerEmpCpf();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerEmpExistOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<EmpInfo>> buildActionsOnPassed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionActionAdapter<EmpInfo>> actions = new ArrayList<>();
		
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
	
	
	
	
	
	
	private static class ActionNodeUpdate implements DecisionActionAdapter<EmpInfo> {
		EmpNodeUpdateL1 treeHelper;
		
		
		public ActionNodeUpdate(DecisionTreeOption<EmpInfo> option) {
			treeHelper = new EmpNodeUpdateL1(option);
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
