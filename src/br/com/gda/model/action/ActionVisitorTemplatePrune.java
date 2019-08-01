package br.com.gda.model.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public abstract class ActionVisitorTemplatePrune<T extends InfoRecord, S extends InfoRecord> implements ActionVisitorPrune<T> {	
	public static boolean PRUNE_WHEN_EMPTY = true;
	public static boolean DONT_PRUNE_WHEN_EMPTY = false;
	
	private DeciTreeOption<S> selOption;
	private Class<S> sClazz;
	

	public ActionVisitorTemplatePrune(Connection conn, String schemaName, Class<S> clazz) {
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
		List<S> selectedInfos = selectToPrune();
		
		if(shouldPrune(selectedInfos))		
			return pruneHook(recordInfos, selectedInfos);
		
		if(shouldPruneWhenEmpty(selectedInfos))
			return Collections.emptyList();
		
		return recordInfos;
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
	
	
	
	private List<S> selectToPrune() {
		ActionStd<S> mainAction = buildAction();
		mainAction.executeAction();
		
		return buildResult(mainAction.getDecisionResult());
	}
	
	
	
	private ActionStd<S> buildAction() {
		if (hasTreeClass())
			return buildActionTree();		
		
		if (hasActionClass())
			return buildActionStd();		
		
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private ActionStd<S> buildActionTree() {
		try {
			Class<? extends DeciTree<S>> actionClass = getTreeClassHook();
			Constructor<? extends DeciTree<S>> actionConstru = actionClass.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionStd<S>) actionConstru.newInstance(selOption).toAction();
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	private ActionStd<S> buildActionStd() {
		try {
			Class<? extends ActionStd<S>> actionClass = getActionClassHook();
			Constructor<? extends ActionStd<S>> actionConstru = actionClass.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionStd<S>) actionConstru.newInstance(selOption);
				
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
	
	
	
	private List<S> buildResult(DeciResult<S> treeResult) {		
		if (treeResult.hasResultset())		
			return treeResult.getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private boolean shouldPrune(List<S> selectedInfos) {
		if(selectedInfos.isEmpty())
			return false;
		
		return true;
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
	
	
	
	protected List<T> pruneHook(List<T> recordInfos, List<S> selectedInfos) {	
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}

	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
