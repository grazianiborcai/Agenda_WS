package br.com.gda.model.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public abstract class ActionLazyTemplate<T,S> implements ActionLazy<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	protected final boolean EMPTY = false;
	
	private DeciTreeOption<S> option;
	private Connection conn; 
	private String schemaName;
	private ActionStd<S> actionHandler;
	private DeciResult<T> resultHandler;
	private DeciResult<T> resultPostAction;
	private List<ActionLazy<T>> postActions;
	
	
	public ActionLazyTemplate(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		
		this.conn = conn;
		this.schemaName = schemaName;
		this.postActions = new ArrayList<>();
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
	}
	
	
		
	@Override public boolean executeAction(T infoRecord) {
		checkArgument(infoRecord);
		
		List<T> infoRecords = new ArrayList<>();
		infoRecords.add(infoRecord);
		
		return executeAction(infoRecords);
	}
	
	
	
	private void checkArgument(T infoRecord) {
		if (infoRecord == null)
			throw new NullPointerException("infoRecord" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override public boolean executeAction(List<T> infoRecords) {
		checkArgument(infoRecords);	
		boolean result = tryToExecuteAction(infoRecords);
		
		if (result == SUCCESS) 
			result = executePostActions();				
		
		return result;
	}
	
	
	
	private void checkArgument(List<T> infoRecords) {
		if (infoRecords == null)
			throw new NullPointerException("infoRecords" + SystemMessage.NULL_ARGUMENT);
		
		if (infoRecords.isEmpty())
			throw new NullPointerException("infoRecords" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	
	private boolean tryToExecuteAction(List<T> infoRecords) {
		option = buildOption(infoRecords);
		
		actionHandler = getInstanceOfActionHook(option);
		actionHandler.executeAction();
		resultHandler = translateResultHook(actionHandler.getDecisionResult());
		boolean result = resultHandler.hasSuccessfullyFinished();
		
		return result;
	}
	
	
	
	private DeciTreeOption<S> buildOption(List<T> infoRecords) {
		DeciTreeOption<S> opt = new DeciTreeOption<>();
		opt.conn = conn;
		opt.schemaName = schemaName;
		opt.recordInfos = translateRecordInfosHook(makeDefensiveCopy(infoRecords));
		
		return opt;
	}
	
	
	
	private List<T> makeDefensiveCopy(List<T> recordInfos) {
		try {
			return tryToMakeDefensiveCopy(recordInfos);
			
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<T> tryToMakeDefensiveCopy(List<T> recordInfos) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (recordInfos == null || recordInfos.isEmpty())
			return recordInfos;
		
		List<T> clonedRecords = new ArrayList<>();
		
		for (T eachRecord: recordInfos) {
			T cloned = (T) eachRecord.getClass().getMethod("clone").invoke(eachRecord);
			clonedRecords.add(cloned);
		}
	
		return clonedRecords;
	}
	
	
	
	protected List<S> translateRecordInfosHook(List<T> recordInfos) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected  ActionStd<S> getInstanceOfActionHook(DeciTreeOption<S> option) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected DeciResult<T> translateResultHook(DeciResult<S> result) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
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
			postAction.executeAction(resultHandler.getResultset());
			resultPostAction = postAction.getDecisionResult();
			return resultPostAction.hasSuccessfullyFinished();
			//return SUCCESS;
		
		} catch (Exception e) {
			buildResultFailed();
			return FAILED;
		}		
	}
	
	
	
	private void buildResultFailed() {
		DeciResultHelper<T> deciResult = new DeciResultHelper<>();		
		deciResult.finishedWithSuccess = false;
		deciResult.failureCode = SystemCode.INTERNAL_ERROR;
		deciResult.failureMessage = SystemMessage.INTERNAL_ERROR;
		deciResult.hasResultset = false;
		deciResult.resultset = null;
		resultPostAction = deciResult;
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		if (resultHandler == null)
			throw new IllegalStateException();
		
		if (resultPostAction != null)
			return resultPostAction;
		
		return resultHandler;
	}
	
	
	
	@Override public ActionStd<T> toAction(List<T> recordInfos) {
		return new ActionLazyAdapter<>(this, recordInfos);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		if (actionHandler == null)
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		
		postActions.add(actionHandler);
	}
}
