package br.com.gda.model.decisionTree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;

abstract class DeciActionHelperTemplate<T> implements DeciAction<T> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;	
	
	private DeciResultHelper<T> deciResult;
	private List<DeciActionHandler<T>> postActions;
	private List<T> resultset = Collections.emptyList();
	
	
	public DeciActionHelperTemplate() {
		deciResult = new DeciResultHelper<>();
		postActions = new ArrayList<>();
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
			resultset = tryToExecuteActionHook();
			//TODO: verificar resultset dummy. Caso positivo, retornar erro de data not found
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
			postAction.executeAction(resultset);
			deciResult.copyFrom(postAction.getDecisionResult());
			return SUCCESS;
		
		} catch (Exception e) {
			buildResultFailed();
			return FAILED;
		}		
	}
	
	
	
	private void buildResultSuccess() {
		deciResult.finishedWithSuccess = true;
		deciResult.hasResultset = true;
		deciResult.resultset = resultset;
	}
	
	
	
	private void buildResultFailed() {
		deciResult.finishedWithSuccess = false;
		deciResult.failureCode = SystemCode.INTERNAL_ERROR;
		deciResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		deciResult.hasResultset = false;
		deciResult.resultset = null;
	}
	
	
	
	public DeciResult<T> getDecisionResult() {
		return this.deciResult;
	}
}
