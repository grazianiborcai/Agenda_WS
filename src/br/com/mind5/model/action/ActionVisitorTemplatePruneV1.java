package br.com.mind5.model.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ActionVisitorTemplatePruneV1<T extends InfoRecord, S extends InfoRecord> implements ActionVisitorPrune_<T> {	
	public static boolean PRUNE_WHEN_EMPTY = true;
	public static boolean DONT_PRUNE_WHEN_EMPTY = false;
	
	private DeciTreeOption<S> selOption;
	private Class<S> sClazz;
	

	public ActionVisitorTemplatePruneV1(Connection conn, String schemaName, Class<S> clazz) {
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
		selOption = addRecordToOption(recordInfos, selOption, sClazz);
		List<S> selectedInfos = selectToPrune(selOption);
		
		if(shouldPrune(selectedInfos))		
			return pruneHook(recordInfos, selectedInfos);
		
		if(shouldPruneWhenEmpty(selectedInfos))
			return Collections.emptyList();
		
		return recordInfos;
	}	
	
	
	
	private DeciTreeOption<S> addRecordToOption(List<T> recordInfos, DeciTreeOption<S> option, Class<S> actionClazz) {
		List<S> translatedInfos = toActionClassHook(recordInfos);
		
		if (translatedInfos == null)
			translatedInfos = toActionClassDefault(recordInfos, actionClazz);
		 
		 option.recordInfos = translatedInfos;
		 return option;
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
	
	
	
	private List<S> selectToPrune(DeciTreeOption<S> option) {
		ActionStdV1<S> mainAction = buildAction(option);
		mainAction.executeAction();
		
		List<S> selectedInfos = buildResult(mainAction.getDecisionResult());
		
		closeAction(mainAction);
		return selectedInfos;
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
			Class<? extends ActionStdV1<S>> actionClass = getActionClassHook();
			Constructor<? extends ActionStdV1<S>> actionConstru = actionClass.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionStdV1<S>) actionConstru.newInstance(option);
				
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
	
	
	
	protected Class<? extends ActionStdV1<S>> getActionClassHook() {
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
	
	
	
	private void closeAction(ActionStdV1<S> action) {
		if (action == null)
			return;
		
		if (action instanceof ActionStdV2)
			((ActionStdV2<S>) action).close();
	}

	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}