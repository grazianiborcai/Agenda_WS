package br.com.gda.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.dao.EmpWtimeStmtExecInsert;
import br.com.gda.employee.dao.EmpWtimeStmtExecUpdate;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpWtimeSoftDelete;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionResultHelper;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeNodeInsOrUpd implements DecisionTree<EmpWTimeInfo> {
	private DecisionTree<EmpWTimeInfo> tree;
	
	
	public EmpWtimeNodeInsOrUpd(DecisionTreeOption<EmpWTimeInfo> option) {
		DecisionTreeHelperOption<EmpWTimeInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.actionOnPassed = new OnPassed(option);
		helperOption.actionOnFailed = new OnFailed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker() {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeSoftDelete();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checker = new CheckerEmpWtimeExistOnDb(EXIST_ON_DB);
		stack.add(checker);		
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	/*
	private DecisionActionAdapter buildOnPassedAction(DecisionTreeOption<EmpWTimeInfo> option) {
		List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions =  buildStmtExecOption(option);
		EmpWtimeStmtExecInsert sqlStmtExecutor = new EmpWtimeStmtExecInsert(stmtExecOptions);
		
		return new DecisionActionStmtHelper<EmpWTimeInfo>(sqlStmtExecutor);
	}
	*/
	
	
	/*
	private List<SqlStmtExecOption<EmpWTimeInfo>> buildStmtExecOption(DecisionTreeOption<EmpWTimeInfo> option) {
		List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			

		SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = option.conn;
		stmtExecOption.recordInfo = makeClone(option.recordInfo);
		stmtExecOption.schemaName = option.schemaName;
		stmtExecOptions.add(stmtExecOption);
		
		return stmtExecOptions;
	}
	*/
	
	
	/*
	private EmpWTimeInfo makeClone(EmpWTimeInfo recordInfo) {
		try {
			return (EmpWTimeInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	*/
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	
	
	
	private static class OnPassed implements DecisionActionAdapter<EmpWTimeInfo> {
		private SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor;
		private DecisionResultHelper<EmpWTimeInfo> decisionResult;
		
		
		public OnPassed(DecisionTreeOption<EmpWTimeInfo> option) {
			decisionResult = new DecisionResultHelper<>();
			buildStmtExec(option);
		}
		
		
		
		private void buildStmtExec(DecisionTreeOption<EmpWTimeInfo> option) {
			List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpWTimeInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}

			
			sqlStmtExecutor = new EmpWtimeStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {
			boolean RESULT_SUCCESS = true;
			boolean RESULT_FAILED = false;			
			
			boolean result = tryToExecuteAction();
			
			if (result == RESULT_SUCCESS)
				buildResultSuccess();
				
			if (result == RESULT_FAILED)
				buildResultFailed();
			
			return result;
		}
		
		
		
		private boolean tryToExecuteAction() {
			try {
				sqlStmtExecutor.executeStmt();
				return true;
			
			} catch (Exception e) {
				return false;
			}			
		}
		
		
		
		private void buildResultSuccess() {
			this.decisionResult.finishedWithSuccess = true;
			this.decisionResult.hasResultset = true;
			this.decisionResult.resultset = this.sqlStmtExecutor.getResultset();
		}
		
		
		private void buildResultFailed() {
			this.decisionResult.finishedWithSuccess = false;
			this.decisionResult.failureCode = SystemCode.INTERNAL_ERROR;
			this.decisionResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		}
		
		
		
		@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
			return this.decisionResult;
		}
	}
	
	
	
	
	
	
	private static class OnFailed implements DecisionActionAdapter<EmpWTimeInfo> {
		private SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor;
		private DecisionResultHelper<EmpWTimeInfo> decisionResult;
		
		
		public OnFailed(DecisionTreeOption<EmpWTimeInfo> option) {
			decisionResult = new DecisionResultHelper<>();
			buildStmtExec(option);
		}
		
		
		
		private void buildStmtExec(DecisionTreeOption<EmpWTimeInfo> option) {
			List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpWTimeInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}

			
			sqlStmtExecutor = new EmpWtimeStmtExecUpdate(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {
			boolean RESULT_SUCCESS = true;
			boolean RESULT_FAILED = false;			
			
			boolean result = tryToExecuteAction();
			
			if (result == RESULT_SUCCESS)
				buildResultSuccess();
				
			if (result == RESULT_FAILED)
				buildResultFailed();
			
			return result;
		}
		
		
		
		private boolean tryToExecuteAction() {
			try {
				sqlStmtExecutor.executeStmt();
				return true;
			
			} catch (Exception e) {
				return false;
			}			
		}
		
		
		
		private void buildResultSuccess() {
			this.decisionResult.finishedWithSuccess = true;
			this.decisionResult.hasResultset = true;
			this.decisionResult.resultset = this.sqlStmtExecutor.getResultset();
		}
		
		
		private void buildResultFailed() {
			this.decisionResult.finishedWithSuccess = false;
			this.decisionResult.failureCode = SystemCode.INTERNAL_ERROR;
			this.decisionResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		}
		
		
		
		@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
			return this.decisionResult;
		}
	}
}
