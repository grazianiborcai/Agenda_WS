package br.com.gda.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;

public abstract class ActionMultiVisitorTemplate<T> implements ActionMultiVisitor<T> {
	protected final boolean IS_TAKEN = true;
	protected final boolean NOT_TAKEN = false;
	protected final boolean FLAGGED = true;
	protected final boolean NOT_FLAGGED = false;
	
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
		boolean result = buildList(infoRecords);	
		
		if (result == SUCCESS)
			result = tryToExecuteAction();
		
		
		if (result == FAILED)
			return buildResultFailed();
		
		
		return buildResultSuccess();
	}
	
	
	
	private boolean buildList(List<List<T>> infoRecords) {
		int index = 0;
		
		for (List<T> eachRecords : infoRecords) {
			index = index + 1;
			boolean hasNext = (infoRecords.size() - 1) < index;
			boolean result = buildListHook(eachRecords, hasNext);
			
			if (result == FAILED)
				return FAILED;
		}		
		
		return SUCCESS;
	}
	
	
	
	protected boolean buildListHook(List<T> infoRecords, boolean hasNext) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private boolean tryToExecuteAction() {
		List<T> results = executeHook();
		
		if (isResultValid(results) == FAILED) 			
			return FAILED;
		
		buildResultRecords(results);		
		return SUCCESS;			
	}
	
	
	
	private boolean isResultValid(List<T> infoRecords) {
		if (infoRecords == null || infoRecords.isEmpty()) 			
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private void buildResultRecords(List<T> infoRecords) {
		resultRecords.addAll(infoRecords);
	}
	
	
	
	protected List<T> executeHook() {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private boolean buildResultSuccess() {
		actionResult = new DeciResultHelper<>();
		actionResult.finishedWithSuccess = SUCCESS;
		actionResult.hasResultset = true;
		actionResult.resultset = resultRecords;
		
		return actionResult.finishedWithSuccess;
	}
	
	
	
	private boolean buildResultFailed() {
		actionResult = new DeciResultHelper<>();
		actionResult.finishedWithSuccess = FAILED;
		actionResult.failureCode = SystemCode.INTERNAL_ERROR;
		actionResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		actionResult.hasResultset = false;
		actionResult.resultset = null;
		
		return actionResult.finishedWithSuccess;
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
