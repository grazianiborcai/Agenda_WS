package br.com.gda.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;

public abstract class ActionStdTemplate<T> implements ActionStd<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;	
	
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
			throwException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
		
		postActions.add(actionHandler);
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
			DeciResult<T> result = tryToExecuteActionResuHook();
			copyResult(result);
			return result.isSuccess();
		
		} catch (Exception e) {
			logException(e);
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
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
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
		
		} catch (Exception e) {
			buildResultError();
			return FAILED;
			//TODO: realmente tratar exception ao inves de dispara-la ?
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
			throwException(new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED));
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
	
	
	
	private void throwException(Exception e) {
		try {
			logException(e);
			throw e;
			
		} catch (Exception e1) {
			logException(new IllegalArgumentException(SystemMessage.WRONG_EXCEPTION));
			throw new IllegalArgumentException(SystemMessage.WRONG_EXCEPTION);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
