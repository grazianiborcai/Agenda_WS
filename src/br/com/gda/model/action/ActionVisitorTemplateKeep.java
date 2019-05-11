package br.com.gda.model.action;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public abstract class ActionVisitorTemplateKeep<T extends InfoRecord, S extends InfoRecord> implements ActionVisitorEnforce<T> {
	private DeciTreeOption<S> selOption;
	private Class<S> sClazz;
	

	public ActionVisitorTemplateKeep(Connection conn, String schemaName, Class<S> clazz) {
		checkArgument(conn, schemaName, clazz);
		makeOption(conn, schemaName);
		
		sClazz = clazz;
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName, Class<S> clazz) {
		if (conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (schemaName == null) {
			logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));	
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (clazz == null) {
			logException(new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT));	
			throw new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void makeOption(Connection conn, String schemaName) {
		selOption = new DeciTreeOption<>();
		selOption.conn = conn;
		selOption.schemaName = schemaName;
		selOption.recordInfos = null;
	}
	
	
		
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		addRecordToOption(recordInfos);
		List<S> selectedInfos = selectToKeep();
		
		return keep(recordInfos, selectedInfos);
	}	
	
	
	
	private void addRecordToOption(List<T> recordInfos) {
		selOption.recordInfos = toActionClassHook(recordInfos);
	}
	
	
	
	protected List<S> toActionClassHook(List<T> recordInfos) {
		//Template method - Default behavior
		return toActionClass(recordInfos);	
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<S> toActionClass(List<T> recordInfos) {
		try {
			S sInstance = sClazz.getConstructor().newInstance();
			
			Method met = sClazz.getMethod("copyFrom", List.class);
			return (List<S>) met.invoke(sInstance, recordInfos);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private List<S> selectToKeep() {
		ActionStd<S> mainAction = getActionHook(selOption);
		mainAction.executeAction();
		
		return buildResult(mainAction.getDecisionResult());
	}
	
	
	
	protected ActionStd<S> getActionHook(DeciTreeOption<S> option) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<S> buildResult(DeciResult<S> treeResult) {		
		if (treeResult.hasResultset())		
			return treeResult.getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<T> keep(List<T> recordInfos, List<S> selectedInfos) {		
		//TODO: Mover regra para dentro de Merger ???
		if (selectedInfos.isEmpty())
			return recordInfos;
		
		
		try {			
			Class<? extends InfoWritterFactory_<T>> keeperClass = getKeeperClassHook();
			Method met = keeperClass.getMethod("keep", List.class, List.class);
			
			InfoWritterFactory_<T> writterInstance = keeperClass.getConstructor().newInstance();
			return (List<T>) met.invoke(writterInstance, new Object[] {selectedInfos, recordInfos});
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	protected Class<? extends InfoWritterFactory_<T>> getKeeperClassHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
