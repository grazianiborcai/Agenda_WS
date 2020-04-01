package br.com.mind5.model.action;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;

public final class ActionStdHelperMap<T, S> extends ActionStdTemplate<T> {
	private Connection actionConn; 
	private String actionSchemaName; 
	private List<T> records;
	private Class<? extends ActionVisitorAction<T>> actionClazz;
	private Class<? extends ActionVisitorMap<T,S>> mapClazz;
	private Map<S,List<T>> recordMap;
	
	
	public ActionStdHelperMap(ActionMapOption<T,S> option) {
		super();
		checkArgument(option);
		initialize(option);
	}
	
	
	
	private void initialize(ActionMapOption<T,S> option) {
		actionConn = option.conn; 
		actionSchemaName = option.schemaName; 
		actionClazz = option.visitorAction;
		mapClazz = option.visitorMap;
		records = makeCopy(option.recordInfos);
		recordMap = mapRecord(records);		
	}
	
	
	
	private List<T> makeCopy(List<T> recordInfos) {
		return super.makeDefensiveCopy(recordInfos);
	}
	
	
	
	private Map<S,List<T>> mapRecord(List<T> recordInfos) {
		Map<S,List<T>> resultMap = new HashMap<>();
		
		for (T eachRecord : recordInfos) {
			S keyInfo = buildMapKey(eachRecord);
			
			List<T> elements = resultMap.get(keyInfo);
			
			if (elements == null) {
				mapInsert(resultMap, keyInfo, eachRecord);
			} else {
				mapUpdate(elements, eachRecord);
			}
		}
		
		return resultMap;
	}
	
	
	
	private void mapInsert(Map<S,List<T>> map, S Key, T element) {
		List<T> elements = new ArrayList<>();
		elements.add(element);
		map.put(Key, elements);		
	}
	
	
	
	private void mapUpdate(List<T> elements, T element) {
		elements.add(element);		
	}
	
	
	
	protected S buildMapKey(T recordInfo) {
		ActionVisitorMap<T,S> visitor = getVisitorActionMap(mapClazz);
		return visitor.buildMapKey(recordInfo);
	}
	
	
	
	private ActionVisitorMap<T,S> getVisitorActionMap(Class<? extends ActionVisitorMap<T,S>> clazz) {
		try {		
			return clazz.getConstructor().newInstance();
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private void checkArgument(ActionMapOption<T,S> option) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos == null) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos.isEmpty()) {
			logException(new IllegalArgumentException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		if (option.visitorAction == null) {
			logException(new NullPointerException("option.visitorAction" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.visitorAction" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.visitorMap == null) {
			logException(new NullPointerException("option.visitorMap" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.visitorMap" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@Override protected DeciResult<T> tryToExecuteActionReturnResuHook() throws SQLException {
		List<T> results = new ArrayList<>();
		DeciResult<T> parcialResult = null;
		
		for (Map.Entry<S,List<T>> eachPair : recordMap.entrySet()) {
			ActionVisitorAction<T> action = getVisitorActionInstance(actionClazz, actionConn, actionSchemaName);
			parcialResult = action.executeTransformation(eachPair.getValue());
			
			if (parcialResult.isSuccess() == super.FAILED)
				return parcialResult;
			
			results = collectResultset(parcialResult, results);
		}
				
		
		return buildResult(parcialResult, results);
	}
	
	
	
	private ActionVisitorAction<T> getVisitorActionInstance(Class<? extends ActionVisitorAction<T>> clazz, Connection conn, String schemaName) {
		try {
			Constructor<? extends ActionVisitorAction<T>> constructor = clazz.getConstructor(Connection.class, String.class);
			Object[] params = {actionConn, actionSchemaName};
			return constructor.newInstance(params);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private List<T> collectResultset(DeciResult<T> actionResult, List<T> results) {
		if (actionResult.hasResultset())
			results.addAll(actionResult.getResultset());
		
		return results;
	}
	
	
	
	private DeciResult<T> buildResult(DeciResult<T> actionResult, List<T> results) {
		checkArgument(actionResult);
		
		DeciResultHelper<T> resultHelper = new DeciResultHelper<T>(); 
		resultHelper.copyWithoutResultset(actionResult);
		resultHelper.resultset = results;		
		
		return resultHelper;
	}
	
	
	
	private void checkArgument(DeciResult<T> actionResult) {
		if (actionResult == null) {
			logException(new NullPointerException("actionResult" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionResult" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
