package br.com.mind5.model.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultError;
import br.com.mind5.model.decisionTree.common.DeciResultNotFound;

public abstract class ActionVisitorTemplateActionV2<T extends InfoRecord, S extends InfoRecord> implements ActionVisitorV2<T> {	
	private ActionStdV1<S> action;
	private Class<T> tClazz;
	

	public ActionVisitorTemplateActionV2(DeciTreeOption<T> option, Class<T> baseClazz, Class<S> actionClazz) {
		checkArgument(option, baseClazz, actionClazz);	
		clear();
		
		tClazz = baseClazz;	
		action = buildAction(option, actionClazz);		
	}
	
	
	
	private ActionStdV1<S> buildAction(DeciTreeOption<T> option, Class<S> actionClazz) {
		DeciTreeOption<S> treeOption = translateOption(option, actionClazz);
		return buildAction(treeOption);
	}
	
	
	
	private DeciTreeOption<S> translateOption(DeciTreeOption<T> sourceOption, Class<S> actionClazz) {
		List<S> translatedInfos = toActionClass(sourceOption.recordInfos, actionClazz);
		
		DeciTreeOption<S> resultOption = new DeciTreeOption<>();		
		resultOption.conn = sourceOption.conn;
		resultOption.schemaName = sourceOption.schemaName;
		resultOption.recordInfos = translatedInfos;
		
		return resultOption;
	}
	
	
	
	private ActionStdV1<S> buildAction(DeciTreeOption<S> option) {
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
		DeciResult<S> actionResult = executeAction(action);
		
		if (actionResult.isSuccess() == false)		
			return copyErrorResult(actionResult);	
		
		if (isResultEmpty(actionResult) == true)
			return makeNotFoundResult();
		
		
		return parseActionResult(actionResult, tClazz);
	}	
	
	
	
	private DeciResult<S> executeAction(ActionStdV1<S> action) {
		if (checkAction(action) == false)
			return makeErrorResult();
		
		action.executeAction();
		DeciResult<S> result = action.getDecisionResult();
		
		closeAction(action);
		return result;
	}
	
	
	
	private boolean isResultEmpty(DeciResult<S> actionResult) {
		if (actionResult.hasResultset() == false)
			return true;
		
		return false;
	}
	
	
	
	private DeciResult<T> parseActionResult(DeciResult<S> actionResult, Class<T> baseClazz) {
		try {
			List<S> resultInfos = getResultInfos(actionResult);
			List<T> translatedInfos = toBaseClass(resultInfos, baseClazz);
			
			return makeResult(translatedInfos);
		
		} catch (Exception e) {
			logException(e);
			return makeErrorResult();
		}
	}
	
	
	
	private List<S> getResultInfos(DeciResult<S> actionResult) {
		if (actionResult.isSuccess() == false)
			return Collections.emptyList();
		
		if (actionResult.hasResultset() == false)
			return Collections.emptyList();
		
		return actionResult.getResultset();
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
	
	
	
	private DeciResult<T> makeResult(List<T> translatedInfos) {
		if (checkTranslatedInfos(translatedInfos) == false) 
			return makeNotFoundResult();
		
		DeciResultHelper<T> helper = new DeciResultHelper<>();
		
		helper.resultset = translatedInfos;
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
	
	
	
	private boolean checkTranslatedInfos(List<T> translatedInfos) {
		if (translatedInfos == null) 
			return false;
		
		if (translatedInfos.isEmpty()) 
			return false;
		
		return true;
	}
	
	
	
	private List<S> toActionClass(List<T> recordInfos, Class<S> actionClazz) {
		List<S> results = toActionClassHook(recordInfos);	
		
		if (results == null)
			results = toActionClassDefault(recordInfos, actionClazz);
		
		return results;
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
	
	
	
	private List<T> toBaseClass(List<S> results, Class<T> baseClazz) {
		List<T> baseInfos = toBaseClassHook(results);	
		
		if (baseInfos == null)
			baseInfos = toBaseClassDefault(results, baseClazz);
		
		return baseInfos;
	}
	
	
	
	protected List<T> toBaseClassHook(List<S> results) {
		//Template method - Default behavior
		return null;	
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<T> toBaseClassDefault(List<S> results, Class<T> baseClazz) {
		try {
			T tInstance = baseClazz.getConstructor().newInstance();
			
			Method met = baseClazz.getMethod("copyFrom", List.class);
			return (List<T>) met.invoke(tInstance, results);
				
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
	
	
	
	protected List<T> _mergeHook(List<T> recordInfos, List<S> selectedInfos) {	
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public void close() {
		closeAction(action);
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
		action = DefaultValue.object();
		tClazz = DefaultValue.object();
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option, Class<T> baseClazz, Class<S> actionClazz) {
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
		
		
		if (baseClazz == null) {
			logException(new NullPointerException("baseClazz" + SystemMessage.NULL_ARGUMENT));	
			throw new NullPointerException("baseClazz" + SystemMessage.NULL_ARGUMENT);
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
