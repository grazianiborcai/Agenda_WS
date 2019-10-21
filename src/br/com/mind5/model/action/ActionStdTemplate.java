package br.com.mind5.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public abstract class ActionStdTemplate<T> implements ActionStd<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;	
	
	private DeciResultHelper<T> actionResult;
	private DeciResultHelper<T> finalResult;
	private List<ActionLazy<T>> postActions;
	private boolean hasExecuted;
	
	
	public ActionStdTemplate() {
		init();
	}
	
	
	
	private void init() {
		actionResult = new DeciResultHelper<>();
		finalResult = new DeciResultHelper<>();
		postActions = new ArrayList<>();
		hasExecuted = false;
	}
	
	
	
	public void addPostAction(ActionLazy<T> actionHandler) {
		checkArgument(actionHandler);
		postActions.add(actionHandler);
	}
	
	
	
	private void checkArgument(ActionLazy<T> actionHandler) {
		if (actionHandler == null) {
			logException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	public boolean executeAction() {
		flagAsExecuted();
		boolean result = tryToExecuteAction();
		
		if (result == SUCCESS) 
			result = executePostActions();				
		
		return result;
	}
	
	
	
	private void flagAsExecuted() {
		hasExecuted = true;
	}
	
	
	
	private boolean tryToExecuteAction() {
		try {
			DeciResult<T> result = tryToExecuteActionReturnResuHook();
			copyToActionResult(result);
			copyToFinalResult(result);
			return result.isSuccess();
		
		} catch (Exception e) {
			logException(e);
			buildResultInternalError();
			return FAILED;
		}			
	}
	
	
	
	protected DeciResult<T> tryToExecuteActionReturnResuHook() throws SQLException {
		List<T> resultRecords = tryToExecuteActionReturnListHook();
		return buildResultFromList(resultRecords);
	}
	
	
	
	protected List<T> tryToExecuteActionReturnListHook() throws SQLException {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> buildResultFromList(List<T> recordInfos) {
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
		//Template Method: default implementation
		return buildResultFailedDefault();
	}
	
	
	
	private DeciResult<T> buildResultFailedDefault() {
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
	
	
	
	private boolean executePostActions() {	
		for (ActionLazy<T> eachAction : postActions) {
			DeciResult<T> postResult = tryToExecutePostActions(eachAction);
			copyToFinalResult(postResult);
			
			if (postResult.isSuccess() == FAILED)
				return FAILED;
		}
				
		return SUCCESS;
	}
	
	
	
	private DeciResult<T> tryToExecutePostActions(ActionLazy<T> postAction) {				
		try {
			postAction.executeAction(actionResult.getResultset());
			return postAction.getDecisionResult();
		
		} catch (Exception e) {
			logException(e);			
			return new DeciResultError<>();
		}		
	}
	
	
	
	private void copyToActionResult(DeciResult<T> result) {
		actionResult.copyFrom(result);
	}
	
	
	
	private void copyToFinalResult(DeciResult<T> result) {
		finalResult.copyFrom(result);
	}
	
	
	
	private void buildResultInternalError() {
		actionResult.copyFrom(new DeciResultError<>());
		finalResult.copyFrom(new DeciResultError<>());
	}
	
	
	
	public DeciResult<T> getDecisionResult() {
		checkState();
		return finalResult;
	}
	
	
	
	private void checkState() {
		if (hasExecuted == false) {
			logException(new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
		}
	}
	
	
	
	protected List<T> makeDefensiveCopy(List<T> recordInfos) {
		List<T> clonedInfos = new ArrayList<>();
		
		for (T eachRecord : recordInfos) {
			T cloned = makeDefensiveCopy(eachRecord);
			clonedInfos.add(cloned);
		}
		
		return clonedInfos;
	}
	
	
	
	protected T makeDefensiveCopy(T recordInfo) {
		return tryToMakeDefensiveCopy(recordInfo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private T tryToMakeDefensiveCopy(T recordInfo) {		
		try {
			return (T) recordInfo.getClass().getMethod("clone").invoke(recordInfo);
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
