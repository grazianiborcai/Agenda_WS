package br.com.mind5.model.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultError;
import br.com.mind5.model.decisionTree.common.DeciResultNotFound;

public abstract class ActionVisitorTemplatePrune<T extends InfoRecord, S extends InfoRecord> implements ActionVisitor<T> {	
	protected final boolean PRUNE_WHEN_EMPTY = true;
	protected final boolean DONT_PRUNE_WHEN_EMPTY = false;
	
	private DeciTreeOption<S> actionOption;
	private List<T> bases;
	

	public ActionVisitorTemplatePrune(DeciTreeOption<T> option, Class<S> actionClazz) {
		checkArgument(option, actionClazz);
		
		bases = makeClone(option.recordInfos);
		actionOption = makeActionOption(option, actionClazz);		
	}
	
	
	
	private DeciTreeOption<S> makeActionOption(DeciTreeOption<T> baseOption, Class<S> actionClazz) {				
		DeciTreeOption<S> resultOption = new DeciTreeOption<>();
		
		resultOption.conn = baseOption.conn;
		resultOption.schemaName = baseOption.schemaName;
		resultOption.recordInfos = translateRecords(baseOption.recordInfos, actionClazz);
		
		return resultOption;
	}
	
	
	
	private List<S> translateRecords(List<T> baseInfos, Class<S> actionClazz) {
		List<S> translatedInfos = toActionClassHook(baseInfos);
		
		if (translatedInfos == null)
			translatedInfos = toActionClassDefault(baseInfos, actionClazz);
		 
		 return translatedInfos;
	}
	
	
	
	protected List<S> toActionClassHook(List<T> recordInfos) {
		//Template method - Default behavior
		return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<S> toActionClassDefault(List<T> recordInfos, Class<S> actionClazz) {
		try {
			S sInstance = actionClazz.getConstructor().newInstance();
			
			Method met = actionClazz.getMethod("copyFrom", List.class);
			return (List<S>) met.invoke(sInstance, recordInfos);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	@Override public DeciResult<T> executeTransformation() {
		checkState();			
		DeciResult<S> actionResult = selectToPrune(actionOption);
		
		if (isResultError(actionResult) == true)
			return makeResultError(actionResult);		 		 
		 
		List<T> prunedInfos = prune(bases, actionResult);
		return makeResult(prunedInfos);
	}	
	
	
	
	private DeciResult<S> selectToPrune(DeciTreeOption<S> option) {
		ActionStd<S> action = buildAction(option);
		action.executeAction();
		
		DeciResult<S> actionResult = action.getDecisionResult();		
		closeAction(action);
		
		return actionResult;
	}
	
	
	
	private ActionStd<S> buildAction(DeciTreeOption<S> option) {
		if (hasTreeClass())
			return buildActionTree(option);		
		
		if (hasActionClass())
			return buildActionStd(option);		
		
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private ActionStd<S> buildActionTree(DeciTreeOption<S> option) {
		try {
			Class<? extends DeciTree<S>> actionClass = getTreeClassHook();
			Constructor<? extends DeciTree<S>> actionConstru = actionClass.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionStd<S>) actionConstru.newInstance(option).toAction();
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private ActionStd<S> buildActionStd(DeciTreeOption<S> option) {
		try {
			Class<? extends ActionStd<S>> actionClass = getActionClassHook();
			Constructor<? extends ActionStd<S>> actionConstru = actionClass.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionStd<S>) actionConstru.newInstance(option);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private boolean hasTreeClass() {
		if (getTreeClassHook() == null)
			return false;
		
		return true;
	}
	
	
	
	protected Class<? extends DeciTree<S>> getTreeClassHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	private boolean hasActionClass() {
		if (getActionClassHook() == null)
			return false;
		
		return true;
	}
	
	
	
	protected Class<? extends ActionStd<S>> getActionClassHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	private List<T> prune(List<T> baseInfos, DeciResult<S> actionResult) {
		List<S> selectedInfos = getResultset(actionResult);
		
		if(shouldPrune(selectedInfos))		
			return pruneHook(baseInfos, selectedInfos);
		
		if(shouldPruneWhenEmpty(selectedInfos) == false)
			return Collections.emptyList();
		
		return baseInfos;
	}
	
	
	
	private List<S> getResultset(DeciResult<S> actionResult) {		
		if (actionResult.hasResultset())		
			return actionResult.getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private boolean shouldPrune(List<S> selectedInfos) {
		if(selectedInfos.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	protected List<T> pruneHook(List<T> recordInfos, List<S> selectedInfos) {	
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	

	
	
	
	private boolean shouldPruneWhenEmpty(List<S> selectedInfos) {
		if(selectedInfos.isEmpty())
			return shouldPruneWhenEmptyHook();
		
		return false;
	}
	
	
	
	protected boolean shouldPruneWhenEmptyHook() {
		//Default Behavior
		return DONT_PRUNE_WHEN_EMPTY;
	}
	
	
	
	private DeciResult<T> makeResult(List<T> prunedInfos) {
		if (prunedInfos == null)
			return makeResultNotFound();
		
		if (prunedInfos.isEmpty())
			return makeResultNotFound();
		
		return makeResultSuccess(prunedInfos);
	}
	
	
	
	private DeciResult<T> makeResultSuccess(List<T> results) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = true;
		result.hasResultset = true;
		result.resultset = results;
		
		return result;
	}
	
	
	
	private boolean isResultError(DeciResult<S> actionResult) {
		if (actionResult.isSuccess() == true)
			return false;
		
		if (actionResult.getFailCode() == SystemCode.DATA_NOT_FOUND)
			return false;
		
		return true;
	}
	
	
	
	private DeciResult<T> makeResultError(DeciResult<S> sourceResult) {
		if (sourceResult.isSuccess())
			return makeResultError();		
		
		DeciResultHelper<T> result = new DeciResultHelper<>();
		result.copyWithoutResultset(sourceResult);		
		
		return result;
	}
	
	
	
	private DeciResult<T> makeResultError() {
		return new DeciResultError<>();
	}
	
	
	
	private DeciResult<T> makeResultNotFound() {
		return new DeciResultNotFound<>();
	}
	
	
	
	@Override public void close() {
		clear();
	}
	
	
	
	private void clear() {
		actionOption = DefaultValue.object();
		bases = DefaultValue.object();
	}
	
	
	
	private void closeAction(ActionStd<S> action) {
		if (action == null)
			return;
		
		if (action instanceof ActionStd)
			((ActionStd<S>) action).close();
	}
	
	
	
	private List<T> makeClone(List<T> baseInfos) {
		return CloneUtil.cloneRecords(baseInfos, this.getClass());
	}
	
	
	
	private void checkState() {
		if (actionOption == null) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option, Class<S> actionClazz) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos == null) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		if (option.recordInfos.isEmpty()) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		if (actionClazz == null) {
			logException(new NullPointerException("actionClazz" + SystemMessage.NULL_ARGUMENT));	
			throw new NullPointerException("actionClazz" + SystemMessage.NULL_ARGUMENT);
		}
	}

	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
