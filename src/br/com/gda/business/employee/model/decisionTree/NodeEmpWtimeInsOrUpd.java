package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpWtimeInsertExec;
import br.com.gda.business.employee.dao.EmpWtimeUpdateExec;
import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.business.employee.model.checker.EmpWtimeCheckSoftDelete;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionStmtHelper;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class NodeEmpWtimeInsOrUpd implements DeciTree<EmpWTimeInfo> {
	private DeciTree<EmpWTimeInfo> tree;
	
	
	public NodeEmpWtimeInsOrUpd(DeciTreeOption<EmpWTimeInfo> option) {
		DeciTreeHelperOption<EmpWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker(DeciTreeOption<EmpWTimeInfo> option) {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		final boolean EXPECTED_NOT_DELETED = false;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXPECTED_NOT_DELETED;
		checker = new EmpWtimeCheckSoftDelete(checkerOption);
		stack.add(checker);

		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<EmpWTimeInfo>> buildActionsOnPassed(DeciTreeOption<EmpWTimeInfo> option) {
		List<DeciAction<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		return actions;
	}
	
	
	
	private List<DeciAction<EmpWTimeInfo>> buildActionsOnFailed(DeciTreeOption<EmpWTimeInfo> option) {
		List<DeciAction<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionUpdate(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	
	
	
	private static class ActionInsert implements DeciAction<EmpWTimeInfo> {
		DeciAction<EmpWTimeInfo> actionHelper;
		
		
		public ActionInsert(DeciTreeOption<EmpWTimeInfo> option) {
			SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpWTimeInfo> buildStmtExec(DeciTreeOption<EmpWTimeInfo> option) {
			List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpWTimeInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpWtimeInsertExec(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
	
	
	
	
	
	
	private static class ActionUpdate implements DeciAction<EmpWTimeInfo> {
		DeciAction<EmpWTimeInfo> actionHelper;
		
		
		public ActionUpdate(DeciTreeOption<EmpWTimeInfo> option) {
			SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpWTimeInfo> buildStmtExec(DeciTreeOption<EmpWTimeInfo> option) {
			List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpWTimeInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpWtimeUpdateExec(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
