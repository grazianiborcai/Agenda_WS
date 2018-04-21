package br.com.gda.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpWtimeStmtExecInsert;
import br.com.gda.employee.dao.EmpWtimeStmtExecUpdate;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeSoftDelete;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class EmpWtimeNodeInsOrUpd implements DecisionTree<EmpWTimeInfo> {
	private DecisionTree<EmpWTimeInfo> tree;
	
	
	public EmpWtimeNodeInsOrUpd(DecisionTreeOption<EmpWTimeInfo> option) {
		DecisionTreeHelperOption<EmpWTimeInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker(DecisionTreeOption<EmpWTimeInfo> option) {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		final boolean EXPECTED_NOT_DELETED = false;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXPECTED_NOT_DELETED;
		checker = new CheckerEmpWtimeSoftDelete(checkerOption);
		stack.add(checker);

		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<EmpWTimeInfo>> buildActionsOnPassed(DecisionTreeOption<EmpWTimeInfo> option) {
		List<DecisionActionAdapter<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		return actions;
	}
	
	
	
	private List<DecisionActionAdapter<EmpWTimeInfo>> buildActionsOnFailed(DecisionTreeOption<EmpWTimeInfo> option) {
		List<DecisionActionAdapter<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionUpdate(option));
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
	
	
	
	
	
	
	private static class ActionInsert implements DecisionActionAdapter<EmpWTimeInfo> {
		DecisionActionAdapter<EmpWTimeInfo> actionHelper;
		
		
		public ActionInsert(DecisionTreeOption<EmpWTimeInfo> option) {
			SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpWTimeInfo> buildStmtExec(DecisionTreeOption<EmpWTimeInfo> option) {
			List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpWTimeInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpWtimeStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
	
	
	
	
	
	
	private static class ActionUpdate implements DecisionActionAdapter<EmpWTimeInfo> {
		DecisionActionAdapter<EmpWTimeInfo> actionHelper;
		
		
		public ActionUpdate(DecisionTreeOption<EmpWTimeInfo> option) {
			SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpWTimeInfo> buildStmtExec(DecisionTreeOption<EmpWTimeInfo> option) {
			List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpWTimeInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpWtimeStmtExecUpdate(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
