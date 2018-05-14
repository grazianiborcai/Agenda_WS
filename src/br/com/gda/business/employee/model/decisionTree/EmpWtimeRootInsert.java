package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.business.employee.model.checker.CheckerEmpWtimeEmpExistOnDb;
import br.com.gda.business.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.business.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
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

public final class EmpWtimeRootInsert implements DecisionTree<EmpWTimeInfo> {
	private DecisionTree<EmpWTimeInfo> tree;
	
	
	public EmpWtimeRootInsert(DecisionTreeOption<EmpWTimeInfo> option) {
		DecisionTreeHelperOption<EmpWTimeInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker(DecisionTreeOption<EmpWTimeInfo> option) {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;	
		ModelCheckerOption checkerOption;
		
		//TODO: trocar por emp_store
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerEmpWtimeEmpExistOnDb(checkerOption);
		stack.add(checker);	
		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CheckerEmpWtimeExistOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<EmpWTimeInfo>> buildActionsOnPassed(DecisionTreeOption<EmpWTimeInfo> option) {
		List<DecisionAction<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsertOrUpdate(option));
		actions.add(new EmpWtimeActionSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
	
	
	private static class ActionInsertOrUpdate implements DecisionAction<EmpWTimeInfo> {
		private DecisionTree<EmpWTimeInfo> forwardTree;
		
		
		public ActionInsertOrUpdate(DecisionTreeOption<EmpWTimeInfo> option) {
			forwardTree = new EmpWtimeNodeInsOrUpd(option);
		}
		
		
		
		@Override public boolean executeAction() {
			forwardTree.makeDecision();
			return forwardTree.getDecisionResult().hasSuccessfullyFinished();
		}	
		
		
		
		@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
			return forwardTree.getDecisionResult();
		}
	}
}
