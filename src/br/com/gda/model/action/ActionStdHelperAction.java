package br.com.gda.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;

public final class ActionStdHelperAction<T> extends ActionStdTemplate<T> {
	private List<T> records = new ArrayList<>();
	private ActionVisitorAction<T> visitorAction;
	
	
	public ActionStdHelperAction(T recordInfo, ActionVisitorAction<T> visitor) {		
		super();
		checkArgument(recordInfo, visitor);
		makeCopy(recordInfo);
		visitorAction = visitor;
	}
	
	
	
	private void makeCopy(T recordInfo) {
		T cloned = super.makeDefensiveCopy(recordInfo);
		records.add(cloned);
	}
	
	
	
	public ActionStdHelperAction(List<T> recordInfos, ActionVisitorAction<T> visitor) {
		super();
		checkArgument(recordInfos, visitor);
		makeCopy(recordInfos);
		visitorAction = visitor;
	}
	
	
	
	private void makeCopy(List<T> recordInfos) {
		records = super.makeDefensiveCopy(recordInfos);
	}
	
	
	
	private void checkArgument(List<T> recordInfos, ActionVisitorAction<T> visitor) {
		if (recordInfos == null)
			throwException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
		
		
		if (recordInfos.isEmpty())
			throwException(new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT));
		
		
		for (T eachRecord : recordInfos) {
			checkArgument(eachRecord, visitor);
		}
	}
	
	
	
	private void checkArgument(T recordInfo, ActionVisitorAction<T> visitor) {
		if (recordInfo == null)
			throwException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
		
		if (visitor == null)
			throwException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
	}
	
	
	
	@Override protected DeciResult<T> tryToExecuteActionResuHook() throws SQLException {
		return visitorAction.executeTransformation(records);
	}
	
	
	
	private void throwException(Exception e) {
		try {
			logException(e);
			throw e;
			
		} catch (Exception e1) {
			logException(new IllegalArgumentException(SystemMessage.WRONG_EXCEPTION));
			throw new IllegalArgumentException(SystemMessage.WRONG_EXCEPTION);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
