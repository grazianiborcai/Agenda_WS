package br.com.mind5.model.action;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.common.DeciResultError;
import br.com.mind5.model.decisionTree.common.DeciResultNotFound;

public abstract class ActionStdTemplateV2<T extends InfoRecord> implements ActionStdV2<T> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;	
	
	private DeciResult<T> actionResult;
	private List<ActionLazyV1<T>> postActions;
	
	
	public ActionStdTemplateV2() {
		clear();
	}
	
	
	
	private void clear() {
		actionResult = DefaultValue.object();
		postActions = DefaultValue.list();
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<T> actionLazy) {
		checkArgument(actionLazy);
		postActions.add(actionLazy);	//TODO: defensive copy
	}
	
	
	
	@Override public boolean executeAction() {
		actionResult = executeBaseAction();				
		actionResult = executePostActions(postActions, actionResult);	
		return actionResult.isSuccess();
	}
	
	
	
	private DeciResult<T> executeBaseAction() {
		try {
			List<T> results = tryToExecuteHook();
			
			if (checkResultset(results) == FAILED)
				return buildResultFailedHook();
			
			return buildResultSuccess(results);
		
		} catch (Exception e) {
			logException(e);
			return buildResultInternalError();
		}			
	}
	
	
	
	protected List<T> tryToExecuteHook() throws SQLException { // retornar DeciResult<T>
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> executePostActions(List<ActionLazyV1<T>> actions, DeciResult<T> baseResult) {	
		if (shouldExecute(actions, baseResult) == FAILED)
			return baseResult;
		
		DeciResult<T> postResult = baseResult;	
		
		 
		for (ActionLazyV1<T> eachAction : actions) {
			List<T> baseInfos = makeClone(baseResult.getResultset());
			postResult = tryToExecutePostActions(eachAction, baseInfos);
			
			if (postResult.isSuccess() == FAILED)
				return postResult;
		}
				
		return postResult;
	}
	
	
	
	private DeciResult<T> tryToExecutePostActions(ActionLazyV1<T> postAction, List<T> baseInfos) {				
		try {
			postAction.executeAction(baseInfos);
			return postAction.getDecisionResult();
		
		} catch (Exception e) {
			logException(e);			
			return new DeciResultError<>();
		}		
	}	
	
	
	
	private DeciResult<T> buildResultInternalError() {
		return new DeciResultError<>();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		checkState(actionResult);
		return makeClone(actionResult);
	}
	
	
	
	protected DeciResult<T> buildResultFailedHook() {
		//Template Method: default implementation
		return buildResultFailedDefault();
	}
	
	
	
	private DeciResult<T> buildResultFailedDefault() {
		return buildResultDataNotFound();
	}
	
	
	
	private DeciResult<T> buildResultDataNotFound() {
		return new DeciResultNotFound<>();
	}
	
	
	
	private DeciResult<T> buildResultSuccess(List<T> recordInfos) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = SUCCESS;
		result.hasResultset = true;
		result.resultset = recordInfos;
		
		return result;
	}
	
	
	
	@Override public void close() {
		closeAction(postActions);
		clear();
	}
	
	
	
	private void closeAction(List<ActionLazyV1<T>> actions) {
		if (actions == null)
			return;
		
		for (ActionLazyV1<T> eachAction : actions)
			closeAction(eachAction);
	}
	
	
	
	private void closeAction(ActionLazyV1<T> action) {
		if (action instanceof ActionLazyV2) {
			((ActionLazyV2<T>) action).close();
		}
	}
	
	
	
	private DeciResult<T> makeClone(DeciResult<T> source) {
		DeciResultHelper<T> copyResult = new DeciResultHelper<>();
		copyResult.copyFrom(source);
		
		return copyResult;
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	private void checkState(DeciResult<T> finalResult) {
		if (hasFinalResult(finalResult) == false) {
			logException(new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
		}
	}
	
	
	
	private boolean hasFinalResult (DeciResult<T> finalResult) {
		if (finalResult == null)
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private boolean hasPostAction(List<ActionLazyV1<T>> actions) {
		if (actions == null)
			return FAILED;
		
		if (actions.isEmpty())
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private boolean checkResultset(List<T> results) {
		if (results == null)
			return FAILED;
		
		if (results.isEmpty())
			return FAILED;
		
		return SUCCESS;
	}	
	
	
	
	private boolean shouldExecute(List<ActionLazyV1<T>> actions, DeciResult<T> baseResult) {
		if (hasPostAction(actions) == FAILED)
			return FAILED;
		 
		if (baseResult.isSuccess() == FAILED)
			return FAILED;
		 
		if (baseResult.hasResultset() == FAILED)
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private void checkArgument(ActionLazyV1<T> actionHandler) {
		if (actionHandler == null) {
			logException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
