package br.com.gda.model.action;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);		
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);	
		
		if (baseClazz == null)
			throw new NullPointerException("baseClazz" + SystemMessage.NULL_ARGUMENT);
		
		if (actionClazz == null)
			throw new NullPointerException("actionClazz" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private void makeOption(Connection conn, String schemaName) {
		selOption = new DeciTreeOption<>();
		selOption.conn = conn;
		selOption.schemaName = schemaName;
		selOption.recordInfos = null;
	}
	
	
		
	@Override public DeciResult<T> executeTransformation(List<T> baseInfos) {
		addRecordToOption(baseInfos);
		DeciResult<S> actionResult = executeAction(selOption);		
		
		return buildResult(actionResult);
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
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> buildResult(DeciResult<S> actionResult) {
		if (actionResult.hasSuccessfullyFinished())
			return translateResult(actionResult);
		
		return buildFailedResult(actionResult);
	}
	
	
	
	private DeciResult<T> translateResult(DeciResult<S> actionResult) {
		DeciResultHelper<T> translatedResult = new DeciResultHelper<>();
		translatedResult.copyWithoutResultset(actionResult);
		
		List<T> translatedRecords = translateToBaseClass(actionResult.getResultset());
		translatedResult.resultset = translatedRecords;
		
		return translatedResult;
	}
	
	
	
	private List<T> translateToBaseClass(List<S> results) {
		return toBaseClassHook(results);
	}
	
	
	
	@SuppressWarnings("unchecked")
	protected List<T> toBaseClassHook(List<S> results) {
		try {
			T tInstance = tClazz.getConstructor().newInstance();
			
			Method met = tClazz.getMethod("copyFrom", List.class);
			return (List<T>) met.invoke(tInstance, results);
				
			} catch (Exception e) {
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private DeciResult<T> buildFailedResult(DeciResult<S> actionResult) {
		DeciResultHelper<T> failedResult = new DeciResultHelper<>();
		failedResult.copyWithoutResultset(actionResult);
		return failedResult;
	}
}
