package br.com.mind5.model.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ActionVisitorTemplateMergeV2<T extends InfoRecord, S extends InfoRecord> implements ActionVisitorMerge<T> {
	public static boolean MERGE_WHEN_EMPTY = true;
	public static boolean DONT_MERGE_WHEN_EMPTY = false;
	
	private DeciTreeOption<S> selOption;
	private Class<S> sClazz;
	

	public ActionVisitorTemplateMergeV2(Connection conn, String schemaName, Class<S> clazz) {
		checkArgument(conn, schemaName, clazz);		
		selOption = makeOption(conn, schemaName);		
		sClazz = clazz;
	}
	
	
	
	private DeciTreeOption<S> makeOption(Connection conn, String schemaName) {
		DeciTreeOption<S> option = new DeciTreeOption<>();
		option.conn = conn;
		option.schemaName = schemaName;
		option.recordInfos = null;
		return option;
	}
	
	
		
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		selOption = addRecordToOption(recordInfos, selOption);
		List<S> selectedInfos = selectToMerge();
		
		if(shouldMerge(selectedInfos))		
			return mergeHook(recordInfos, selectedInfos);
		
		return Collections.emptyList();
	}	
	
	
	
	private DeciTreeOption<S> addRecordToOption(List<T> recordInfos, DeciTreeOption<S> option) {
		option.recordInfos = toActionClassHook(recordInfos);
		return option;
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
	
	
	
	private List<S> selectToMerge() {
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
	
	
	
	private boolean shouldMerge(List<S> selectedInfos) {
		boolean mergeWhenEmpty = shouldMergeWhenEmptyHook();
		
		if(selectedInfos.isEmpty())
			return mergeWhenEmpty;
		
		return true;
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

	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
