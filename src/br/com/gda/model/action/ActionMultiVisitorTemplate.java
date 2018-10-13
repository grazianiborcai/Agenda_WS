package br.com.gda.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;

public abstract class ActionMultiVisitorTemplate<T> implements ActionMultiVisitor<T> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private List<T> resultRecords;
	private DeciResultHelper<T> actionResult;
	
	
	protected ActionMultiVisitorTemplate() {
		init();
	}

	
	
	protected ActionMultiVisitorTemplate(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);	
		init();
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private void init() {
		resultRecords = new ArrayList<>();
		actionResult = null;
	}
	
	
	
	@Override public boolean executeAction(List<List<T>> infoRecords) {
		int index = 0;
		
		for (List<T> eachRecords : infoRecords) {
			index = index + 1;
			boolean hasNext = (infoRecords.size() - 1) < index;
			boolean result = tryToExecuteAction(index, eachRecords, hasNext);
			
			if (result == FAILED) {
				buildResultFailed();
				return FAILED;
			}	
		}		
		
		buildResultSuccess();
		return SUCCESS;
	}
	
	
	
	private boolean tryToExecuteAction(int index, List<T> infoRecords, boolean hasNext) {
		List<T> results = executeHook(index, infoRecords, hasNext);
		
		if (results == null || results.isEmpty()) 			
			return FAILED;
		
		resultRecords.addAll(results);		
		return SUCCESS;			
	}
	
	
	
	protected List<T> executeHook(int index, List<T> infoRecords, boolean hasNext) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void buildResultSuccess() {
		actionResult = new DeciResultHelper<>();
		actionResult.finishedWithSuccess = SUCCESS;
		actionResult.hasResultset = true;
		actionResult.resultset = resultRecords;
	}
	
	
	
	private void buildResultFailed() {
		actionResult = new DeciResultHelper<>();
		actionResult.finishedWithSuccess = FAILED;
		actionResult.failureCode = SystemCode.INTERNAL_ERROR;
		actionResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		actionResult.hasResultset = false;
		actionResult.resultset = null;
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		checkState();
		return actionResult;
	}
	
	
	
	private void checkState() {
		if (hasExecuted() == false)
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
	}
	
	
	
	private boolean hasExecuted() {
		if (actionResult == null)
			return false;
		
		return true;
	}
}
