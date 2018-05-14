package br.com.gda.model.decisionTree;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmtExec;

public final class DecisionActionStmtHelper<T> implements DecisionAction<T> {
	private SqlStmtExec<T> sqlStmtExecutor;
	private DecisionResultHelper<T> decisionResult;
	
	public DecisionActionStmtHelper(SqlStmtExec<T> sqlStmtExecutor) {
		checkArgument(sqlStmtExecutor);
		
		this.sqlStmtExecutor = sqlStmtExecutor;
		decisionResult = new DecisionResultHelper<>();
	}
	
	
	
	private void checkArgument(SqlStmtExec<T> sqlStmtExecutor) {
		if (sqlStmtExecutor == null)
			throw new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT);
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
	
	
	
	@Override public DecisionResult<T> getDecisionResult() {
		return this.decisionResult;
	}
}
