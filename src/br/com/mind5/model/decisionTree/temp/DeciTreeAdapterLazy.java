package br.com.mind5.model.decisionTree.temp;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public final class DeciTreeAdapterLazy<T extends InfoRecord> implements ActionLazy<T> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;
	
	private enum TreeState {EMPTY, INSTANCIATED, EXECUTED, CLOSED};
	
	private Class<? extends DeciTree<T>> treeClazz;
	private ActionStd<T> treeAction;
	private DeciTreeOption<T> treeOption;
	private TreeState treeState;
	private List<ActionLazy<T>> postActions;
	private DeciResult<T> treeResult;
	
	
	
	public DeciTreeAdapterLazy(DeciTreeOption<T> option, Class<? extends DeciTree<T>> treeVisitorClazz) {
		checkArgument(option, treeVisitorClazz);
		init();
		
		treeOption = buildTreeOption(option);
		treeClazz = treeVisitorClazz;
	}
	
	
	
	@Override public boolean executeAction(T infoRecord) {
		List<T> infoRecords = new ArrayList<>();
		infoRecords.add(infoRecord);		
		
		return executeAction(infoRecords);
	
	}
	
	
	
	@Override public boolean executeAction(List<T> infoRecords) {
		checkArgument(infoRecords);
		checkStateExecutable();
		
		treeAction = toAction(infoRecords);
		treeResult = execute(treeAction, postActions);
		
		return treeResult.isSuccess();
	}
	
	
	
	@Override public ActionStd<T> toAction(List<T> infoRecords) {
		checkArgument(infoRecords);
		checkStateExecutable();
		
		return buildAction(treeOption, infoRecords, treeClazz);
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		checkStateResult();
		
		return makeCopy(treeResult);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionLazy) {
		checkArgument(actionLazy);
		postActions.add(actionLazy);	//TODO: defensive copy
	}
	
	
	
	@Override public void close() {
		closeAction(treeAction);
		clear();
		
		treeState = TreeState.CLOSED;
	}
	
	
	
	private DeciResult<T> execute(ActionStd<T> action, List<ActionLazy<T>> lazyActions) {
		action.executeAction();
		DeciResult<T> result = action.getDecisionResult();
		uptState();
		
		result = executePostActions(lazyActions, result);
		
		return result;
	}
	
	
	
	private DeciResult<T> executePostActions(List<ActionLazy<T>> actions, DeciResult<T> baseResult) {	
		if (shouldExecute(actions, baseResult) == FAILED)
			return baseResult;
		
		DeciResult<T> postResult = baseResult;	
		
		 
		for (ActionLazy<T> eachAction : actions) {
			List<T> baseInfos = makeClone(baseResult.getResultset());
			postResult = tryToExecutePostActions(eachAction, baseInfos);
			
			if (postResult.isSuccess() == FAILED)
				return postResult;
		}
				
		return postResult;
	}
	
	
	
	private boolean shouldExecute(List<ActionLazy<T>> actions, DeciResult<T> baseResult) {
		if (hasPostAction(actions) == FAILED)
			return FAILED;
		 
		if (baseResult.isSuccess() == FAILED)
			return FAILED;
		 
		if (baseResult.hasResultset() == FAILED)
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private boolean hasPostAction(List<ActionLazy<T>> actions) {
		if (actions == null)
			return FAILED;
		
		if (actions.isEmpty())
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private DeciResult<T> makeCopy(DeciResult<T> result) {
		DeciResultHelper<T> helper = new DeciResultHelper<T>();
		helper.copyFrom(treeResult);
		
		return helper;
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	
	private DeciResult<T> tryToExecutePostActions(ActionLazy<T> postAction, List<T> baseInfos) {				
		try {
			postAction.executeAction(baseInfos);
			return postAction.getDecisionResult();
		
		} catch (Exception e) {
			logException(e);			
			return new DeciResultError<>();
		}		
	}
	
	
	
	private void uptState() {
		treeState = TreeState.EXECUTED;
	}
	
	
	
	private ActionStd<T> buildAction(DeciTreeOption<T> option, List<T> infoRecords, Class<? extends DeciTree<T>> clazz) {
		DeciTree<T> tree = buildTree(option, infoRecords, clazz);
		return tree.toAction();
	}
	
	
	
	private DeciTree<T> buildTree(DeciTreeOption<T> option, List<T> infoRecords, Class<? extends DeciTree<T>> clazz) {
		DeciTreeOption<T> lazyTreeOption = buildTreeOption(option, infoRecords);
		return buildTree(lazyTreeOption, clazz);
	}
	
	
	
	private DeciTree<T> buildTree(DeciTreeOption<T> option, Class<? extends DeciTree<T>> clazz) {
		try {
			Constructor<? extends DeciTree<T>> actionConstru = clazz.getConstructor(new Class[]{DeciTreeOption.class});
			return (DeciTree<T>) actionConstru.newInstance(option);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private DeciTreeOption<T> buildTreeOption(DeciTreeOption<T> option, List<T> infoRecords) {
		DeciTreeOption<T> result = buildTreeOption(option);
		result.recordInfos = makeClone(infoRecords);
		
		return result;
	}
	
	
	
	private DeciTreeOption<T> buildTreeOption(DeciTreeOption<T> option) {
		DeciTreeOption<T> result = new DeciTreeOption<>();
		
		result.conn = option.conn;
		result.schemaName = option.schemaName;
		
		return result;
	}
	
	
	
	private void init() {
		clear();
		treeState = TreeState.EMPTY;
		postActions = new ArrayList<>();
	}
	
	
	
	private void closeAction(ActionStd<T> action) {
		if (action == null)
			return;
		
		action.close();
	}
	
	
	
	private void clear() {
		treeClazz = DefaultValue.object();
		treeAction = DefaultValue.object();
		treeOption = DefaultValue.object();		
		postActions = DefaultValue.object();
		treeResult = DefaultValue.object();
	}
	
	
	
	private void checkStateExecutable() {
		if (treeState == null) {
			logException(new IllegalStateException(SystemMessage.OBJ_NOT_INITIALIED));
			throw new IllegalStateException(SystemMessage.OBJ_NOT_INITIALIED);
		}
		
		
		if (treeState == TreeState.EXECUTED) {
			logException(new IllegalStateException(SystemMessage.ACTION_ALREADY_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_ALREADY_EXECUTED);
		}
		
		
		if (treeState == TreeState.CLOSED) {
			logException(new IllegalStateException(SystemMessage.ACTION_ALREADY_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_ALREADY_EXECUTED);
		}
	}
	
	
	
	private void checkStateResult() {
		if (treeState == null) {
			logException(new IllegalStateException(SystemMessage.OBJ_NOT_INITIALIED));
			throw new IllegalStateException(SystemMessage.OBJ_NOT_INITIALIED);
		}
		
		
		if (treeState != TreeState.EXECUTED) {
			logException(new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
		}
		
		
		if (treeState == TreeState.CLOSED) {
			logException(new IllegalStateException(SystemMessage.ACTION_ALREADY_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_ALREADY_EXECUTED);
		}
	}
	
	
	
	private void checkArgument(List<T> infoRecords) {
		if (infoRecords == null) {
			logException(new NullPointerException("infoRecords" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("infoRecords" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (infoRecords.isEmpty()) {
			logException(new IllegalArgumentException("infoRecords" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("infoRecords" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		
		for (T eachRecord : infoRecords) {
			if (eachRecord == null) {
				logException(new IllegalArgumentException("infoRecords" + SystemMessage.EMPTY_ARGUMENT));
				throw new IllegalArgumentException("infoRecords" + SystemMessage.EMPTY_ARGUMENT);
			}
		}
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option, Class<?> treeVisitorClazz) {
		if (treeVisitorClazz == null) {
			logException(new NullPointerException("treeVisitorClazz" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("treeVisitorClazz" + SystemMessage.NULL_ARGUMENT);
		}
		
		checkArgument(option);
	}	
	
	
	
	private void checkArgument(DeciTreeOption<T> option) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new IllegalArgumentException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new IllegalArgumentException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}	
	}
	
	
	
	private void checkArgument(ActionLazy<T> actionHandler) {
		if (actionHandler == null) {
			logException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
