package br.com.gda.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpStmtExecInsert;
import br.com.gda.employee.dao.EmpStmtExecUpdate;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.employee.model.checker.CheckerEmpSoftDelete;
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

final class EmpNodeInsOrUpd implements DecisionTree<EmpInfo> {
	private DecisionTree<EmpInfo> tree;
	
	
	public EmpNodeInsOrUpd(DecisionTreeOption<EmpInfo> option) {
		DecisionTreeHelperOption<EmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DecisionTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		
		final boolean EXPECTED_NOT_DELETED = false;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXPECTED_NOT_DELETED;
		checker = new CheckerEmpSoftDelete(checkerOption);
		stack.add(checker);

		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<EmpInfo>> buildActionsOnPassed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionActionAdapter<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		return actions;
	}
	
	
	
	private List<DecisionActionAdapter<EmpInfo>> buildActionsOnFailed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionActionAdapter<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionUpdate(option));
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
	
	
	
	
	
	
	private static class ActionInsert implements DecisionActionAdapter<EmpInfo> {
		DecisionActionAdapter<EmpInfo> actionHelper;
		
		
		public ActionInsert(DecisionTreeOption<EmpInfo> option) {
			SqlStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpInfo> buildStmtExec(DecisionTreeOption<EmpInfo> option) {
			List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<EmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
	
	
	
	
	
	
	private static class ActionUpdate implements DecisionActionAdapter<EmpInfo> {
		DecisionActionAdapter<EmpInfo> actionHelper;
		
		
		public ActionUpdate(DecisionTreeOption<EmpInfo> option) {
			SqlStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpInfo> buildStmtExec(DecisionTreeOption<EmpInfo> option) {
			List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpStmtExecUpdate(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<EmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
