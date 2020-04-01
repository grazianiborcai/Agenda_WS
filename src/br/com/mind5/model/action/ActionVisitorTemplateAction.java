package br.com.mind5.model.action;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ActionVisitorTemplateAction<T extends InfoRecord, S extends InfoRecord> implements ActionVisitorAction<T> {
	private DeciTreeOption<S> selOption;
	private Class<T> tClazz;
	private Class<S> sClazz;
	

	public ActionVisitorTemplateAction(Connection conn, String schemaName, Class<T> baseClazz, Class<S> actionClazz) {
		checkArgument(conn, schemaName, baseClazz, actionClazz);
		makeOption(conn, schemaName);
		tClazz = baseClazz;
		sClazz = actionClazz;
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName, Class<T> baseClazz, Class<S> actionClazz) {
		if (conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (schemaName == null) {
			logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));	
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
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
	
	
	
	private void makeOption(Connection conn, String schemaName) {
		selOption = new DeciTreeOption<>();
		selOption.conn = conn;
		selOption.schemaName = schemaName;
		selOption.recordInfos = null;
	}
	
	
		
	@Override public DeciResult<T> executeTransformation(List<T> baseInfos) {
		checkArgument(baseInfos);
		addRecordToOption(baseInfos);
		DeciResult<S> actionResult = executeAction(selOption);		
		
		return buildResult(baseInfos, actionResult);
	}
	
	
	
	private void checkArgument(List<T> baseInfos) {
		if (baseInfos == null) {
			logException(new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("baseInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (baseInfos.isEmpty()) {
			logException(new IllegalArgumentException("baseInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("baseInfos" + SystemMessage.EMPTY_ARGUMENT);
		}	
	}
	
	
	
	private void addRecordToOption(List<T> baseInfos) {
		selOption.recordInfos = translateToActionClass(baseInfos);
	}
	
	
	
	private List<S> translateToActionClass(List<T> baseInfos) {
		return toActionClassHook(baseInfos);
	}
	
	
	
	@SuppressWarnings("unchecked")
	protected List<S> toActionClassHook(List<T> baseInfos) {
		try {
			S sInstance = sClazz.getConstructor().newInstance();
			
			Method met = sClazz.getMethod("copyFrom", List.class);
			return (List<S>) met.invoke(sInstance, baseInfos);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private DeciResult<S> executeAction(DeciTreeOption<S> option) {
		ActionStd<S> action = getActionHook(option);
		action.executeAction();
		return action.getDecisionResult();
	}
	
	
	
	protected ActionStd<S> getActionHook(DeciTreeOption<S> option) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> buildResult(List<T> baseInfos, DeciResult<S> actionResult) {
		if (actionResult.isSuccess())
			return translateResult(baseInfos, actionResult);
		
		return buildFailedResult(actionResult);
	}
	
	
	
	private DeciResult<T> translateResult(List<T> baseInfos, DeciResult<S> actionResult) {
		DeciResultHelper<T> translatedResult = new DeciResultHelper<>();
		translatedResult.copyWithoutResultset(actionResult);
		
		List<T> translatedRecords = translateToBaseClass(baseInfos, actionResult.getResultset());
		translatedResult.resultset = translatedRecords;
		
		return translatedResult;
	}
	
	
	
	private List<T> translateToBaseClass(List<T> baseInfos, List<S> results) {
		return toBaseClassHook(baseInfos, results);
	}
	
	
	
	@SuppressWarnings("unchecked")
	protected List<T> toBaseClassHook(List<T> baseInfos, List<S> results) {
		try {
			T tInstance = tClazz.getConstructor().newInstance();
			
			Method met = tClazz.getMethod("copyFrom", List.class);
			return (List<T>) met.invoke(tInstance, results);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private DeciResult<T> buildFailedResult(DeciResult<S> actionResult) {
		DeciResultHelper<T> failedResult = new DeciResultHelper<>();
		failedResult.copyWithoutResultset(actionResult);
		return failedResult;
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
