package br.com.gda.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmtExec;

public final class DeciActionHelper<T> implements DeciAction<T> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;	
	
	private SqlStmtExec<T> stmtExec;
	private DeciResultHelper<T> deciResult;
	private List<DeciActionHandler<T>> postActions;
	
	
	public DeciActionHelper(SqlStmtExec<T> sqlStmtExecutor) {
		checkArgument(sqlStmtExecutor);
		
		stmtExec = sqlStmtExecutor;
		deciResult = new DeciResultHelper<>();
		postActions = new ArrayList<>();
	}
	
	
	
	private void checkArgument(SqlStmtExec<T> sqlStmtExecutor) {
		if (sqlStmtExecutor == null)
			throw new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	public void addPostAction(DeciActionHandler<T> actionHandler) {
		if (actionHandler == null)
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		
		postActions.add(actionHandler);
	}
	
	
	
	public boolean executeAction() {
		boolean result = tryToExecuteAction();
		
		if (result == SUCCESS) 
			result = executePostActions();				
		
		return result;
	}
	
	
	
	private boolean tryToExecuteAction() {
		try {
			stmtExec.executeStmt();
			buildResultSuccess();
			return SUCCESS;
		
		} catch (Exception e) {
			buildResultFailed();
			return FAILED;
		}			
	}
	
	
	
	private boolean executePostActions() {				
		boolean result = true;
		
		for (DeciActionHandler<T> eachAction : postActions) {
			result = tryToExecutePostActions(eachAction);
			
			if (result == FAILED)
				return result;
		}
				
		return result;
	}
	
	
	
	private boolean tryToExecutePostActions(DeciActionHandler<T> postAction) {				
		try {
			postAction.executeAction(stmtExec.getResultset());
			deciResult.copyFrom(postAction.getDecisionResult());
			return SUCCESS;
		
		} catch (Exception e) {
			buildResultFailed();
			return FAILED;
		}		
	}
	
	
	
	private void buildResultSuccess() {
		this.deciResult.finishedWithSuccess = true;
		this.deciResult.hasResultset = true;
		this.deciResult.resultset = stmtExec.getResultset();
	}
	
	
	
	private void buildResultFailed() {
		this.deciResult.finishedWithSuccess = false;
		this.deciResult.failureCode = SystemCode.INTERNAL_ERROR;
		this.deciResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		this.deciResult.hasResultset = false;
		this.deciResult.resultset = null;
	}
	
	
	
	public DeciResult<T> getDecisionResult() {
		return this.deciResult;
	}
}
