package br.com.mind5.model.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.common.CloneUtil;
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

public abstract class ActionVisitorTemplateAction<T extends InfoRecord, S extends InfoRecord> implements ActionVisitor<T> {	
	private ActionStd<S> action;
	private Class<T> tClazz;
	private List<T> bases;
	

	public ActionVisitorTemplateAction(DeciTreeOption<T> option, Class<T> baseClazz, Class<S> actionClazz) {
		checkArgument(option, baseClazz, actionClazz);	
		clear();
		
		tClazz = baseClazz;	
		bases = getBaseInfos(option);	
		action = buildAction(option, actionClazz);		
	}
	
	
	
	private List<T> getBaseInfos(DeciTreeOption<T> option) {
		return makeClone(option.recordInfos);
	}
	
	
	
	private ActionStd<S> buildAction(DeciTreeOption<T> option, Class<S> actionClazz) {
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
	
	
		
	@Override public DeciResult<T> executeTransformation() {
		DeciResult<S> actionResult = executeAction(action);
		
		if (actionResult.isSuccess() == false)		
			return copyErrorResult(actionResult);	
		
		if (isResultEmpty(actionResult) == true)
			return makeNotFoundResult();
		
		
		return parseActionResult(tClazz, bases, actionResult);
	}	
	
	
	
	private DeciResult<S> executeAction(ActionStd<S> action) {
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
	
	
	
	private DeciResult<T> parseActionResult(Class<T> baseClazz, List<T> baseInfos, DeciResult<S> actionResult) {
		try {
			List<S> resultInfos = getResultInfos(actionResult);
			List<T> translatedInfos = toBaseClass(baseClazz, baseInfos, resultInfos);
			
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
	
	
	
	private boolean checkAction(ActionStd<S> action) {
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
	
	
	
	private List<S> toActionClassDefault(List<T> recordInfos, Class<S> actionClazz) {
		if (isSameClass(recordInfos, actionClazz))
			return toActionClassDefaultClone(recordInfos, actionClazz);		

		return toActionClassDefaultCopy(recordInfos, actionClazz);
	}
	
	
	
	private boolean isSameClass(List<T> recordInfos, Class<S> actionClazz) {
		if (recordInfos.isEmpty())
			return false;
		
		T tRecord = recordInfos.get(0);
		
		if(tRecord.getClass() == actionClazz)
			return true;
		
		return false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<S> toActionClassDefaultClone(List<T> recordInfos, Class<S> actionClazz) {
		try {
			List<S> copies = new ArrayList<>();
			
			for(T eachRecord : recordInfos) {
				S eachCopy = (S) eachRecord.clone();
				copies.add(eachCopy);
			}
			
			return copies;
				
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<S> toActionClassDefaultCopy(List<T> recordInfos, Class<S> actionClazz) {
		try {
			S sInstance = actionClazz.getConstructor().newInstance();
			
			Method met = actionClazz.getMethod("copyFrom", List.class);
			return (List<S>) met.invoke(sInstance, recordInfos);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private List<T> toBaseClass(Class<T> baseClazz, List<T> baseInfos, List<S> results) {
		List<T> newBaseInfos = toBaseClassHook(baseInfos, results);	
		
		if (newBaseInfos == null)
			newBaseInfos = toBaseClassDefault(results, baseClazz);
		
		return newBaseInfos;
	}
	
	
	
	protected List<T> toBaseClassHook(List<T> baseInfos, List<S> results) {
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
	
	
	
	protected Class<? extends ActionStd<S>> getActionClassHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	@Override public void close() {
		closeAction(action);
		clear();
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void closeAction(ActionStd<S> action) {
		if (action == null)
			return;
		
		if (action instanceof ActionStd)		
			((ActionStd<T>) action).close();
	}
	
	
	
	private void clear() {
		action = DefaultValue.object();
		tClazz = DefaultValue.object();
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
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
