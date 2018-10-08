package br.com.gda.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
	private List<T> resultset;
	private boolean hasExecuted;
	
	
	public ActionStdTemplate() {
		deciResult = new DeciResultHelper<>();
		postActions = new ArrayList<>();
		resultset = Collections.emptyList();
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
			resultset = tryToExecuteActionHook();
			
			if (isResultsetEmpty()) {
				tryToBuildResultFailed();
				return FAILED;
			}
			
			buildResultSuccess();
			return SUCCESS;
		
		} catch (Exception e) {
			buildResultFailed();
			return FAILED;
		}			
	}
	
	
	
	protected List<T> tryToExecuteActionHook() throws SQLException {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private boolean isResultsetEmpty() {
		if (resultset == null || resultset.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	
	
	private void tryToBuildResultFailed() {
		DeciResult<T> failedResult = buildResultFailedHook();		
		deciResult.copyWithoutResultset(failedResult);
		
		if (failedResult.hasResultset()) 
			deciResult.resultset = failedResult.getResultset();
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
			postAction.executeAction(resultset);
			deciResult.copyFrom(postAction.getDecisionResult());
			return SUCCESS;
		
		} catch (Exception e) {
			buildResultFailed();
			return FAILED;
		}		
	}
	
	
	
	private void buildResultSuccess() {
		deciResult.finishedWithSuccess = SUCCESS;
		deciResult.hasResultset = true;
		deciResult.resultset = resultset;
	}
	
	
	
	private void buildResultFailed() {
		deciResult.finishedWithSuccess = FAILED;
		deciResult.failureCode = SystemCode.INTERNAL_ERROR;
		deciResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		deciResult.hasResultset = false;
		deciResult.resultset = null;
	}
	
	
	
	protected DeciResult<T> buildResultFailedHook() {
		//Template Method: Default behavior
		return buildResultDataNotFound();
	}
	
	
	private DeciResult<T> buildResultDataNotFound() {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.finishedWithSuccess = FAILED;
		result.failureCode = SystemCode.DATA_NOT_FOUND;
		result.failureMessage = SystemMessage.DATA_NOT_FOUND;
		result.hasResultset = false;
		result.resultset = null;
		
		return result;
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
