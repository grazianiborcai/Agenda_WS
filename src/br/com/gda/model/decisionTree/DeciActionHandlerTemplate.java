package br.com.gda.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class DeciActionHandlerTemplate<T,S> implements DeciActionHandler<T> {
	private final boolean SUCCESS = true;
	private final boolean FAIL = false;
	
	private DeciTreeOption<S> option;
	private Connection conn; 
	private String schemaName;
	private DeciAction<S> actionHandler;
	private DeciResult<T> resultHandler;
	
	
	public DeciActionHandlerTemplate(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		
		this.conn = conn;
		this.schemaName = schemaName;
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override public boolean executeAction(List<T> infoRecords) {
		checkArgument(infoRecords);		
		
		for(T eachRecord: infoRecords) {
			if (executeAction(eachRecord) == FAIL)
				return FAIL;
		}		
		
		return SUCCESS;
	}
	
	
	
	private void checkArgument(List<T> infoRecords) {
		if (infoRecords == null)
			throw new NullPointerException("infoRecords" + SystemMessage.NULL_ARGUMENT);
		
		if (infoRecords.isEmpty())
			throw new NullPointerException("infoRecords" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	
	
	@Override public boolean executeAction(T infoRecord) {
		checkArgument(infoRecord);
		return tryToExecuteAction(infoRecord);
	}
	
	
	
	private void checkArgument(T infoRecord) {
		if (infoRecord == null)
			throw new NullPointerException("infoRecord" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private boolean tryToExecuteAction(T infoRecord) {
		List<T> infoRecords = new ArrayList<>();
		infoRecords.add(infoRecord);
		
		option = new DeciTreeOption<>();
		option.conn = conn;
		option.schemaName = schemaName;
		option.recordInfos = translateRecordInfosHook(infoRecords);
		
		actionHandler = getInstanceOfActionHook(option);
		boolean result = actionHandler.executeAction();
		resultHandler = translateResultHook(actionHandler.getDecisionResult());
		
		return result;
	}
	
	
	
	protected List<S> translateRecordInfosHook(List<T> recordInfos) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected  DeciAction<S> getInstanceOfActionHook(DeciTreeOption<S> option) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected DeciResult<T> translateResultHook(DeciResult<S> result) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		if (resultHandler == null)
			throw new IllegalStateException();
		
		return resultHandler;
	}
	
	
	
	@Override public DeciAction<T> toAction(List<T> recordInfos) {
		return new DeciActionHandlerAdapter<>(this, recordInfos);
	}
}
