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

public abstract class ActionVisitorTemplateMergeV2<T extends InfoRecord, S extends InfoRecord> implements ActionVisitorV2<T> {
	protected boolean MERGE_WHEN_EMPTY = true;
	protected boolean DONT_MERGE_WHEN_EMPTY = false;
	
	private List<T> bases;
	private ActionStdV1<S> actionSelect;
	

	public ActionVisitorTemplateMergeV2(DeciTreeOption<T> option, Class<S> clazz) {
		checkArgument(option, clazz);	
		clear();
		
		bases = getBaseInfos(option);		
		actionSelect = buildActionToSelect(option, clazz);		
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<T> getBaseInfos(DeciTreeOption<T> option) {
		return (List<T>) makeClone(option.recordInfos);
	}
	
	
	
	private ActionStdV1<S> buildActionToSelect(DeciTreeOption<T> option, Class<S> sClazz) {
		DeciTreeOption<S> actionOption = translateOption(option, sClazz);
		return buildAction(actionOption);
	}
	
	
	
	private DeciTreeOption<S> translateOption(DeciTreeOption<T> sourceOption, Class<S> sClazz) {
		List<S> translatedInfos = toActionClass(sourceOption.recordInfos, sClazz);
		
		if(translatedInfos == null)
			return null;
		
		if (translatedInfos.isEmpty())
			return null;
		
		return toActionOption(sourceOption, translatedInfos);
	}
	
	
	
	private DeciTreeOption<S> toActionOption(DeciTreeOption<T> sourceOption, List<S> translatedInfos) {
		DeciTreeOption<S> resultOption = new DeciTreeOption<>();
		
		resultOption.conn = sourceOption.conn;
		resultOption.schemaName = sourceOption.schemaName;
		resultOption.recordInfos = translatedInfos;
		
		return resultOption;
	}
	
	
	
	private ActionStdV1<S> buildAction(DeciTreeOption<S> option) {
		if (option == null)
			return null;
		
		if (hasTreeClass())
			return buildActionTree(option);		
		
		if (hasActionClass())
			return buildActionStd(option);		
		
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private ActionStdV1<S> buildActionTree(DeciTreeOption<S> option) {
		try {
			Class<? extends DeciTree<S>> actionClass = getTreeClassHook();
			Constructor<? extends DeciTree<S>> actionConstru = actionClass.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionStdV1<S>) actionConstru.newInstance(option).toAction();
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private ActionStdV1<S> buildActionStd(DeciTreeOption<S> option) {
		try {
			Class<? extends ActionStdV2<S>> actionClass = getActionClassHook();
			Constructor<? extends ActionStdV2<S>> actionConstru = actionClass.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionStdV1<S>) actionConstru.newInstance(option);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
		
	@Override public DeciResult<T> executeTransformation() {
		DeciResult<S> actionResult = executeAction(actionSelect);
		
		if (shouldMergeOnError(actionResult) == false)		
			return copyErrorResult(actionResult);
		
		if (shouldMergeOnEmpty(actionResult) == false)		
			return makeNotFoundResult();			
		
		if (isResultEmpty(actionResult) == true)
			return makeEmptyResult(bases);
		
		
		return merge(bases, actionResult);
	}	
	
	
	
	private DeciResult<S> executeAction(ActionStdV1<S> action) {
		if (checkAction(action) == false)
			return makeNotFoundResult();
		
		action.executeAction();
		DeciResult<S> result = action.getDecisionResult();
		
		closeAction(action);
		return result;
	}	
	
	
	
	private boolean shouldMergeOnError(DeciResult<S> actionResult) {
		if (actionResult.isSuccess() == true)
			return true;
		
		
		if (isDataNotFoundError(actionResult) == true)
			return shouldMergeWhenEmptyHook();
		
		
		return false;
	}
	
	
	
	private boolean shouldMergeOnEmpty(DeciResult<S> actionResult) {
		if (actionResult.hasResultset()	== true)
			return true;
		
	
		return shouldMergeWhenEmptyHook();
	}
	
	
	
	private boolean isResultEmpty(DeciResult<S> actionResult) {
		if (actionResult.hasResultset() == false)
			return true;
		
		return false;
	}
	
	
	
	private List<S> getSelectedInfos(DeciResult<S> actionResult) {
		if (actionResult.isSuccess() == false)
			return Collections.emptyList();
		
		if (actionResult.hasResultset() == false)
			return Collections.emptyList();
		
		return actionResult.getResultset();
	}
	
	
	
	private DeciResult<T> merge(List<T> baseInfos, DeciResult<S> actionResult) {
		try {
			List<S> selectedInfos = getSelectedInfos(actionResult);
			List<T> mergedResults = mergeHook(baseInfos, selectedInfos);
			
			return makeMergeResult(mergedResults);
		
		} catch (Exception e) {
			logException(e);
			return makeErrorResult();
		}
	}
	
	
	
	private DeciResult<T> copyErrorResult(DeciResult<S> actionResult) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = actionResult.isSuccess();
		
		if (actionResult.isSuccess() == false) {
			result.failMessage = actionResult.getFailMessage();
			result.failCode = actionResult.getFailCode();
		}
		
		result.hasResultset = false;
		
		return result;	
	}
	
	
	
	private boolean checkAction(ActionStdV1<S> action) {
		if (action == null)
			return false;
		
		return true;
	}
	
	
	
	private DeciResult<T> makeEmptyResult(List<T> baseInfos) {
		if (checkMergedInfos(baseInfos) == false) 
			return makeNotFoundResult();
		
		DeciResultHelper<T> helper = new DeciResultHelper<>();
		
		helper.resultset = baseInfos;
		helper.isSuccess = true;;
		helper.hasResultset = true;
		
		return helper;
	}
	
	
	
	private DeciResult<T> makeMergeResult(List<T> margedInfos) {
		if (checkMergedInfos(margedInfos) == false) 
			return makeNotFoundResult();
		
		DeciResultHelper<T> helper = new DeciResultHelper<>();
		
		helper.resultset = margedInfos;
		helper.isSuccess = true;
		helper.hasResultset = true;
		
		return helper;
	}
	
	
	
	private <K extends InfoRecord> DeciResult<K> makeErrorResult() {
		return new DeciResultError<K>();
	}
	
	
	
	private <K extends InfoRecord> DeciResult<K> makeNotFoundResult() {
		return new DeciResultNotFound<K>();
	}
	
	
	
	private boolean checkMergedInfos(List<T> margedInfo) {
		if (margedInfo == null) 
			return false;
		
		if (margedInfo.isEmpty()) 
			return false;
		
		return true;
	}
	
	
	
	private boolean isDataNotFoundError(DeciResult<S> actionResult) {
		return (actionResult.getFailCode() == SystemCode.DATA_NOT_FOUND);
	}
	
	
	
	private List<S> toActionClass(List<T> recordInfos, Class<S> sClazz) {
		List<S> results = toActionClassHook(recordInfos);	
		
		if (results == null)
			results = toActionClassDefault(recordInfos, sClazz);
		
		return results;
	}
	
	
	
	protected List<S> toActionClassHook(List<T> recordInfos) {
		//Template method - Default behavior
		return null;	
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<S> toActionClassDefault(List<T> recordInfos, Class<S> sClazz) {
		try {
			S sInstance = sClazz.getConstructor().newInstance();
			
			Method met = sClazz.getMethod("copyFrom", List.class);
			return (List<S>) met.invoke(sInstance, recordInfos);
				
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
	
	
	
	protected Class<? extends ActionStdV2<S>> getActionClassHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	protected boolean shouldMergeWhenEmptyHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected List<T> mergeHook(List<T> recordInfos, List<S> selectedInfos) {	
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public void close() {
		closeAction(actionSelect);
		clear();
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void closeAction(ActionStdV1<S> action) {
		if (action == null)
			return;
		
		if (action instanceof ActionStdV2)		
			((ActionStdV2<T>) action).close();
	}
	
	
	
	private void clear() {
		bases = DefaultValue.list();
		actionSelect = DefaultValue.object();
	}
	
	
	
	private List<? extends InfoRecord> makeClone(List<? extends InfoRecord> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option, Class<S> clazz) {
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
		
		
		if (clazz == null) {
			logException(new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT));	
			throw new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT);
		}
	}

	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
