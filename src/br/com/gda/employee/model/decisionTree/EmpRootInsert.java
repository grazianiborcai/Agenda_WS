package br.com.gda.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpInfo;
import br.com.gda.employee.model.checker.CheckerEmpExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpMandatoryWrite;
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

public final class EmpRootInsert implements DecisionTree<EmpInfo> {
	private DecisionTree<EmpInfo> tree;
	
	
	public EmpRootInsert(DecisionTreeOption<EmpInfo> option) {
		DecisionTreeHelperOption<EmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DecisionTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		
		checker = new CheckerEmpMandatoryWrite();
		stack.add(checker);
		
		final boolean DONT_EXIST_ON_DB = false;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CheckerEmpExistOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<EmpInfo>> buildActionsOnPassed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionActionAdapter<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsertOrUpdate(option));
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
	
	
	

	
	
	
	private static class ActionInsertOrUpdate implements DecisionActionAdapter<EmpInfo> {
		private DecisionTree<EmpInfo> forwardTree;
		
		
		public ActionInsertOrUpdate(DecisionTreeOption<EmpInfo> option) {
			forwardTree = new EmpNodeInsOrUpd(option);
		}
		
		
		
		@Override public boolean executeAction() {
			forwardTree.makeDecision();
			return forwardTree.getDecisionResult().hasSuccessfullyFinished();
		}	
		
		
		
		@Override public DecisionResult<EmpInfo> getDecisionResult() {
			return forwardTree.getDecisionResult();
		}
	}
}
