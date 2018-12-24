package br.com.gda.model.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.sizeToTrigger < MIN_SIZE) {
			logException(new NullPointerException(SystemMessage.MIN_SIZE_REQUIRED + MIN_SIZE));
			throw new NullPointerException(SystemMessage.MIN_SIZE_REQUIRED + MIN_SIZE);
		}
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
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sizeToTrigger <= 0) {
			logException(new NullPointerException("sizeToTrigger" + SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new NullPointerException("sizeToTrigger" + SystemMessage.POSITIVE_NUM_EXPECTED);
		}
	}
	
	
	
	protected ActionMultiTemplate(Connection conn, String schemaName, int sizeToTrigger) {
		checkArgument(conn, schemaName, sizeToTrigger);
		
		this.sizeToExecute = sizeToTrigger;
		this.conn = conn;
		this.schemaName = schemaName;
		this.postActions = new ArrayList<>();
		this.recordLists = new ArrayList<>();
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName, int sizeToTrigger) {		
		if (conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (schemaName == null) {
			logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sizeToTrigger <= 0) {
			logException(new NullPointerException("sizeToTrigger" + SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new NullPointerException("sizeToTrigger" + SystemMessage.POSITIVE_NUM_EXPECTED);
		}
	}
	
	
	
	@Override public boolean executeAction(T infoRecord) {
		checkArgument(infoRecord);
		
		List<T> infoRecords = new ArrayList<>();
		infoRecords.add(infoRecord);
		
		return executeAction(infoRecords);
	}
	
	
	
	private void checkArgument(T infoRecord) {
		if (infoRecord == null) {
			logException(new NullPointerException("infoRecord" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("infoRecord" + SystemMessage.NULL_ARGUMENT);
		}
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
		if (infoRecords == null) {
			logException(new NullPointerException("infoRecords" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("infoRecords" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (infoRecords.isEmpty()) {
			logException(new NullPointerException("infoRecords" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("infoRecords" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void checkListSize() {
		if (hasEnoughElement()) {
			logException(new IllegalStateException(SystemMessage.LIMIT_EXCEEDED));
			throw new IllegalStateException(SystemMessage.LIMIT_EXCEEDED);
		}
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
			logException(e);
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
		return visitorResult.isSuccess();
	}
	
	
	
	protected ActionMultiVisitor<T> getInstanceOfVisitorHook(Connection conn, String schemaName) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
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
			logException(e);
			buildResultFailed();
			return FAILED;
		}		
	}
	
	
	
	private void buildResultFailed() {
		DeciResultHelper<T> deciResult = new DeciResultHelper<>();		
		deciResult.isSuccess = false;
		deciResult.failCode = SystemCode.INTERNAL_ERROR;
		deciResult.failMessage = SystemMessage.INTERNAL_ERROR;
		deciResult.hasResultset = false;
		deciResult.resultset = null;
		resultPostAction = deciResult;
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		//checkState();
		
		if (resultPostAction != null)
			return resultPostAction;
		
		if (visitorResult != null)
			return visitorResult;
		
		return buildParcialResult();
	}
	
	
	/*
	private void checkState() {
		if (hasExecuted() == false) {
			logException(new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
		}
	}
	
	
	
	private boolean hasExecuted() {
		if (visitorResult != null)
			return true;
		
		if (resultPostAction != null)
			return true;
		
		return false;
	}*/
	
	
	
	private DeciResult<T> buildParcialResult() {
		DeciResultHelper<T> deciResult = new DeciResultHelper<>();		
		deciResult.isSuccess = true;
		deciResult.hasResultset = true;
		deciResult.resultset = recordLists.get(recordLists.size()-1);
		return deciResult;
	}
	
	
	
	@Override public ActionStd<T> toAction(List<T> recordInfos) {
		//TODO: Verificar se esse metodo faz sentido implementar
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		if (actionHandler == null) {
			logException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		}
		
		postActions.add(actionHandler);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
