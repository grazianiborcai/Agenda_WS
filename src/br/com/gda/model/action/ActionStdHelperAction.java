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
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		for (T eachRecord : recordInfos) {
			checkArgument(eachRecord, visitor);
		}
	}
	
	
	
	private void checkArgument(T recordInfo, ActionVisitorAction<T> visitor) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@Override protected DeciResult<T> tryToExecuteActionReturnResuHook() throws SQLException {
		return visitorAction.executeTransformation(records);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
