package br.com.gda.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;

public abstract class ActionStdTemplate<T> implements ActionStd<T> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;	
	
	private DeciResultHelper<T> deciResult;
	private List<ActionLazy<T>> postActions;
	private boolean hasExecuted;
	
	
	public ActionStdTemplate() {
		deciResult = new DeciResultHelper<>();
		postActions = new ArrayList<>();
		hasExecuted = false;
	}
	
	
	
	public void addPostAction(ActionLazy<T> actionHandler) {
		if (actionHandler == null)
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		
		postActions.add(actionHandler);
	}
	
	
	
	public boolean executeAction() {
		hasExecuted = true;
		boolean result = tryToExecuteAction();
		
		if (result == SUCCESS) 
			result = executePostActions();				
		
		return result;
	}
	
	
	
	private boolean tryToExecuteAction() {
		try {
			DeciResult<T> result = tryToExecuteActionResuHook();
			copyResult(result);
			return result.isSuccess();
		
		} catch (Exception e) {
			buildResultError();
			return FAILED;
		}			
	}
	
	
	
	protected DeciResult<T> tryToExecuteActionResuHook() throws SQLException {
		List<T> resultRecords = tryToExecuteActionListHook();
		return buildResult(resultRecords);
	}
	
	
	
	protected List<T> tryToExecuteActionListHook() throws SQLException {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> buildResult(List<T> recordInfos) {
		if (recordInfos.isEmpty()) 
			return buildResultFailed();
			
		return buildResultSuccess(recordInfos);
		
	}
	
	
	
	private DeciResult<T> buildResultFailed() {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		DeciResult<T> failedResult = buildResultFailedHook();		
		result.copyWithoutResultset(failedResult);
		
		if (failedResult.hasResultset()) 
			result.resultset = failedResult.getResultset();
		
		return result;
	}
	
	
	
	protected DeciResult<T> buildResultFailedHook() {
		//Template Method: Default behavior
		return buildResultDataNotFound();
	}
	
	
	
	private DeciResult<T> buildResultDataNotFound() {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = FAILED;
		result.failCode = SystemCode.DATA_NOT_FOUND;
		result.failMessage = SystemMessage.DATA_NOT_FOUND;
		result.hasResultset = false;
		result.resultset = null;
		
		return result;
	}
	
	
	
	private DeciResult<T> buildResultSuccess(List<T> recordInfos) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = SUCCESS;
		result.hasResultset = true;
		result.resultset = recordInfos;
		
		return result;
	}
	
	
	
	private void copyResult(DeciResult<T> result) {
		deciResult.copyFrom(result);
	}
	
	
	
	private boolean executePostActions() {				
		boolean result = true;
		
		for (ActionLazy<T> eachAction : postActions) {
			result = tryToExecutePostActions(eachAction);
			
			if (result == FAILED)
				return result;
		}
				
		return result;
	}
	
	
	
	private boolean tryToExecutePostActions(ActionLazy<T> postAction) {				
		try {
			postAction.executeAction(deciResult.getResultset());
			copyResult(postAction.getDecisionResult());
			return postAction.getDecisionResult().isSuccess();
			//return SUCCESS;
		
		} catch (Exception e) {
			buildResultError();
			return FAILED;
		}		
	}
	
	
	
	private void buildResultError() {
		deciResult.isSuccess = FAILED;
		deciResult.failCode = SystemCode.INTERNAL_ERROR;
		deciResult.failMessage = SystemMessage.INTERNAL_ERROR;
		deciResult.hasResultset = false;
		deciResult.resultset = null;
	}
	
	
	
	public DeciResult<T> getDecisionResult() {
		checkState();
		return this.deciResult;
	}
	
	
	
	private void checkState() {
		if (hasExecuted == false)
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
	}
}
