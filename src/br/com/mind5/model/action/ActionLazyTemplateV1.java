package br.com.mind5.model.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ActionLazyTemplateV1<T extends InfoRecord, S extends InfoRecord> implements ActionLazyV1<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	protected final boolean EMPTY = false;
	
	private DeciTreeOption<S> option;
	private Connection conn; 
	private String schemaName;
	private ActionStdV1<S> actionHandler;
	private DeciResult<T> resultHandler;
	private DeciResult<T> resultPostAction;
	private List<ActionLazyV1<T>> postActions;
	
	
	public ActionLazyTemplateV1(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		
		this.conn = conn;
		this.schemaName = schemaName;
		this.postActions = new ArrayList<>();
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (schemaName == null) {
			logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
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
		boolean result = tryToExecuteAction(infoRecords);
		
		if (result == SUCCESS) 
			result = executePostActions();				
		
		return result;
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
	
	
	
	private boolean tryToExecuteAction(List<T> infoRecords) {
		option = buildOption(infoRecords);
		
		actionHandler = getInstanceOfActionHook(option);
		actionHandler.executeAction();
		resultHandler = translateResultHook(actionHandler.getDecisionResult());
		boolean result = resultHandler.isSuccess();
		
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
	
	
	
	protected List<S> translateRecordInfosHook(List<T> recordInfos) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected  ActionStdV1<S> getInstanceOfActionHook(DeciTreeOption<S> option) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected DeciResult<T> translateResultHook(DeciResult<S> result) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private boolean executePostActions() {				
		boolean result = true;
		
		for (ActionLazyV1<T> eachAction : postActions) {
			result = tryToExecutePostActions(eachAction);
			
			if (result == FAILED)
				return result;
		}
				
		return result;
	}
	
	
	
	private boolean tryToExecutePostActions(ActionLazyV1<T> postAction) {				
		try {
			postAction.executeAction(resultHandler.getResultset());
			resultPostAction = postAction.getDecisionResult();
			return resultPostAction.isSuccess();
		
		} catch (Exception e) {
			buildResultFailed();
			return FAILED;
			//TODO: realmente tratar erro ao inves de passar a exception
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
		if (resultHandler == null) {
			logException(new IllegalStateException());
			throw new IllegalStateException();
			//TODO: Mudar para NullException e adicionar motivo do erro
		}
		
		
		if (resultPostAction != null)
			return resultPostAction;
		
		return resultHandler;
	}
	
	
	
	@Override public ActionStdV1<T> toAction(List<T> recordInfos) {
		return new ActionLazyAdapter<>(this, recordInfos);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<T> actionHandler) {
		if (actionHandler == null) {
			logException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		}
		
		postActions.add(actionHandler);
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}