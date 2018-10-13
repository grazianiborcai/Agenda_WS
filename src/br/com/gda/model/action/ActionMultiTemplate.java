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

public abstract class ActionMultiTemplate<T> implements ActionLazy<T>{
	private final int MIN_SIZE = 2;
	private final boolean NOT_ENOUGH_ELEMENTS = true;
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	
	private int sizeToExecute;
	private Connection conn; 
	private String schemaName;
	private DeciResult<T> visitorResult;
	private DeciResult<T> resultPostAction;
	private List<ActionLazy<T>> postActions;
	private List<List<T>> recordLists;
	private ActionMultiVisitor<T> visitor;
	
	
	protected ActionMultiTemplate(ActionMultiOption<T> option) {
		checkArgument(option);
		
		sizeToExecute = option.sizeToTrigger;
		conn = option.conn;
		schemaName = option.schemaName;
		postActions = new ArrayList<>();
		recordLists = new ArrayList<>();
	}
	
	
	
	private void checkArgument(ActionMultiOption<T> option) {
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		
		if (option.conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (option.schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
		
		if (option.sizeToTrigger < MIN_SIZE)
			throw new NullPointerException(SystemMessage.MIN_SIZE_REQUIRED + MIN_SIZE);
	}
	
	
	
	protected ActionMultiTemplate(DeciTreeOption<T> option, int sizeToTrigger) {
		checkArgument(option, sizeToTrigger);
		
		sizeToExecute = sizeToTrigger;
		conn = option.conn;
		schemaName = option.schemaName;
		postActions = new ArrayList<>();
		recordLists = new ArrayList<>();
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option, int sizeToTrigger) {
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		
		if (option.conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (option.schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
		
		if (sizeToTrigger <= 0)
			throw new NullPointerException("sizeToTrigger" + SystemMessage.POSITIVE_NUM_EXPECTED);
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
		checkListSize();
		addToList(infoRecords);		
		
		if (hasEnoughElement()) {
			boolean result = tryToExecuteAction(infoRecords);
			
			if (result == SUCCESS) 
				result = executePostActions();				
			
			return result;
		}		
		
		return NOT_ENOUGH_ELEMENTS;
	}
	
	
	
	private void checkArgument(List<T> infoRecords) {
		if (infoRecords == null)
			throw new NullPointerException("infoRecords" + SystemMessage.NULL_ARGUMENT);
		
		if (infoRecords.isEmpty())
			throw new NullPointerException("infoRecords" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	
	private void checkListSize() {
		if (hasEnoughElement())
			throw new IllegalStateException(SystemMessage.LIMIT_EXCEEDED);
	}
	
	
	
	private boolean hasEnoughElement() {
		return recordLists.size() >= sizeToExecute;
	}
	
	
	
	private void addToList(List<T> infoRecords) {
		List<T> clones = makeDefensiveCopy(infoRecords);
		recordLists.add(makeDefensiveCopy(clones));
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
	
	
	
	private boolean tryToExecuteAction(List<T> infoRecords) {
		visitor = getInstanceOfVisitorHook(conn, schemaName);
		visitor.executeAction(recordLists);
		visitorResult = visitor.getDecisionResult();
		return visitorResult.hasSuccessfullyFinished();
	}
	
	
	
	protected ActionMultiVisitor<T> getInstanceOfVisitorHook(Connection conn, String schemaName) {
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
			postAction.executeAction(visitorResult.getResultset());
			resultPostAction = postAction.getDecisionResult();
			return SUCCESS;
		
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
		if (hasExecuted() == false)
			throw new IllegalStateException();
		
		if (resultPostAction != null)
			return resultPostAction;
		
		if (visitorResult != null)
			return visitorResult;
		
		return buildParcialResult();
	}
	
	
	
	private boolean hasExecuted() {
		if (visitorResult != null)
			return true;
		
		if (resultPostAction != null)
			return true;
		
		return false;
	}
	
	
	
	private DeciResult<T> buildParcialResult() {
		DeciResultHelper<T> deciResult = new DeciResultHelper<>();		
		deciResult.finishedWithSuccess = true;
		deciResult.hasResultset = true;
		deciResult.resultset = recordLists.get(recordLists.size()-1);
		return deciResult;
	}
	
	
	
	@Override public ActionStd<T> toAction(List<T> recordInfos) {
		//TODO: Verificar se esse metodo faz sentido implementar
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		if (actionHandler == null)
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		
		postActions.add(actionHandler);
	}
}
