package br.com.gda.model.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;

public final class ActionStdHelperAction<T> extends ActionStdTemplate<T> {
	private List<T> records = new ArrayList<>();
	private ActionVisitorAction<T> visitorAction;
	
	
	public ActionStdHelperAction(T recordInfo, ActionVisitorAction<T> visitor) {		
		super();
		checkArgument(recordInfo, visitor);
		makeDefensiveCopy(recordInfo);
		visitorAction = visitor;
	}
	
	
	
	public ActionStdHelperAction(List<T> recordInfos, ActionVisitorAction<T> visitor) {
		super();
		checkArgument(recordInfos, visitor);
		makeDefensiveCopy(recordInfos);
		visitorAction = visitor;
	}
	
	
	
	private void checkArgument(List<T> recordInfos, ActionVisitorAction<T> visitor) {
		if (recordInfos == null)
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		
		
		if (recordInfos.isEmpty())
			throw new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (T eachRecord : recordInfos) {
			checkArgument(eachRecord, visitor);
		}
	}
	
	
	
	private void checkArgument(T recordInfo, ActionVisitorAction<T> visitor) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private void makeDefensiveCopy(List<T> recordInfos) {
		for (T eachRecord : recordInfos) {
			makeDefensiveCopy(eachRecord);
		}
	}
	
	
	
	private void makeDefensiveCopy(T recordInfo) {
		try {
			tryToMakeDefensiveCopy(recordInfo);
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private void tryToMakeDefensiveCopy(T recordInfo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {		
		@SuppressWarnings("unchecked")
		T recordCloned = (T) recordInfo.getClass().getMethod("clone").invoke(recordInfo);
		records.add(recordCloned);		
	}
	
	
	
	@Override protected DeciResult<T> tryToExecuteActionResuHook() throws SQLException {
		return visitorAction.executeTransformation(records);
	}
}
