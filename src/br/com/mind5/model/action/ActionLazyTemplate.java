package br.com.mind5.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public abstract class ActionLazyTemplate<T extends InfoRecord, S extends InfoRecord> implements ActionLazy<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	protected final boolean EMPTY = false;
	
	private Connection conn; 
	private String schemaName;
	private ActionStdV1<S> mainAction;
	private DeciResult<T> actionResult;
	private List<ActionLazy<T>> postActions;
	
	
	public ActionLazyTemplate(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		
		this.conn = conn;
		this.schemaName = schemaName;
		this.postActions = new ArrayList<>();
	}
	
	
		
	@Override public boolean executeAction(T infoRecord) {
		checkArgument(infoRecord);
		
		List<T> infoRecords = toList(infoRecord);		
		return executeAction(infoRecords);
	}
	
	
	
	@Override public boolean executeAction(List<T> infoRecords) {
		checkStateClosed();
		checkArgument(infoRecords);	
		
		mainAction = getMainAction(infoRecords);
		actionResult = executeMainAction(mainAction);	
		
		if (actionResult.isSuccess() == SUCCESS) 
			actionResult = executePostActions(postActions, actionResult);			
		
		return actionResult.isSuccess();
	}
	
	
	
	private ActionStdV1<S> getMainAction(List<T> infoRecords) {
		DeciTreeOption<S> option = buildOption(infoRecords);		
		return getInstanceOfActionHook(option);
	}
	
	
	
	private DeciResult<T> executeMainAction(ActionStdV1<S> action) {
		action.executeAction();
		return translateResultHook(action.getDecisionResult());
	}
	
	
	
	private DeciTreeOption<S> buildOption(List<T> infoRecords) {
		DeciTreeOption<S> opt = new DeciTreeOption<>();
		
		opt.conn = conn;
		opt.schemaName = schemaName;
		opt.recordInfos = translateRecordInfosHook(makeClone(infoRecords));
		
		return opt;
	}
	
	
	
	private DeciResult<T> executePostActions(List<ActionLazy<T>> lazyActions, DeciResult<T> mainResult) {				
		DeciResult<T> lazyResult = mainResult; 
		
		if (hasPostActions(lazyActions) == FAILED)
			return lazyResult;
		
		
		for (ActionLazy<T> eachLazy : lazyActions) {
			lazyResult = tryToExecutePostAction(eachLazy, mainResult.getResultset());
			
			if (lazyResult.isSuccess() == FAILED)
				return lazyResult;
		}
				
		return lazyResult;
	}
	
	
	
	private DeciResult<T> tryToExecutePostAction(ActionLazy<T> postAction, List<T> resultset) {				
		try {
			List<T> copies = makeClone(resultset);			
			postAction.executeAction(copies);			
			return postAction.getDecisionResult();
		
		} catch (Exception e) {
			return makeErrorResult();
		}		
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		checkStateClosed();
		checkStateExecuted();
		
		return actionResult;
	}
	
	
	
	@Override public ActionStdV1<T> toAction(List<T> recordInfos) {
		checkStateClosed();
		return new ActionLazyAdapter<>(this, recordInfos);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> lazyAction) {
		checkStateClosed();
		checkArgument(lazyAction);		
		
		postActions.add(lazyAction);
	}
	
	
	
	@Override public void close() {
		closePostActions(postActions);
		closeAction(mainAction);
		clear();
	}
	
	
	
	private void closeAction(ActionStdV1<S> action) {
		if (action == null)
			return;
		
		if (action instanceof ActionStdV2)
			((ActionStdV2<S>) action).close();
	}
	
	
	
	private void closePostActions(List<ActionLazy<T>> lazyActions) {
		if (lazyActions == null)
			return;
		
		if (lazyActions.isEmpty())
			return;
		
		for (ActionLazy<T> eachLazy : lazyActions) {
			closePostAction(eachLazy);
		}
	}
	
	
	
	private void closePostAction(ActionLazy<T> lazyAction) {
		if (lazyAction == null)
			return;
		
		if (lazyAction instanceof ActionLazy)
			((ActionLazy<T>) lazyAction).close();
	}
	
	
	
	private void clear() {
		conn = DefaultValue.object();
		schemaName = DefaultValue.object();
		mainAction = DefaultValue.object();
		actionResult = DefaultValue.object();
		postActions = DefaultValue.object();
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
	
	
	
	private DeciResult<T> makeErrorResult() {
		return new DeciResultError<T>();
	}
	
	
	
	private List<T> toList(T infoRecord) {
		List<T> infoRecords = new ArrayList<>();
		infoRecords.add(makeClone(infoRecord));
		
		return infoRecords;
	}
	
	
	
	private boolean hasPostActions(List<ActionLazy<T>> lazyActions) {
		if (lazyActions == null)
			return FAILED;
		
		if (lazyActions.isEmpty())
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private T makeClone(T recordInfo) {
		return CloneUtil.cloneRecord(recordInfo, this.getClass());
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	private void checkStateExecuted() {
		if (actionResult == null) {		
			logException(new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
		}
	}
	
	
	
	private void checkStateClosed() {
		if (conn == null) {		
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
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
	
	
	
	private void checkArgument(T infoRecord) {
		if (infoRecord == null) {
			logException(new NullPointerException("infoRecord" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("infoRecord" + SystemMessage.NULL_ARGUMENT);
		}
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
	
	
	
	private void checkArgument(ActionLazy<T> lazyAction) {
		if (lazyAction == null) {
			logException(new NullPointerException("lazyAction" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("lazyAction" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
