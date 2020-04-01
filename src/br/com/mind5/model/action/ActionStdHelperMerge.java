package br.com.mind5.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public final class ActionStdHelperMerge<T> extends ActionStdTemplate<T> {
	private List<T> records;
	private ActionVisitorMerge<T> visitorMerge;
	
	
	public ActionStdHelperMerge(T recordInfo, ActionVisitorMerge<T> visitor) {		
		super();
		init();
		checkArgument(recordInfo, visitor);
		records = makeCopy(recordInfo, records);
		visitorMerge = visitor;
	}
	
	
	
	private void init() {
		records = new ArrayList<>();
	}
	
	
	
	private List<T> makeCopy(T recordInfo, List<T> recordInfos) {
		T cloned = super.makeDefensiveCopy(recordInfo);
		recordInfos.add(cloned);
		return recordInfos;
	}
	
	
	
	public ActionStdHelperMerge(List<T> recordInfos, ActionVisitorMerge<T> visitor) {
		super();
		checkArgument(recordInfos, visitor);
		makeCopy(recordInfos);
		visitorMerge = visitor;
	}
	
	
	
	private void makeCopy(List<T> recordInfos) {
		records = super.makeDefensiveCopy(recordInfos);
	}
	
	
	
	private void checkArgument(List<T> recordInfos, ActionVisitorMerge<T> visitor) {
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
	
	
	
	private void checkArgument(T recordInfo, ActionVisitorMerge<T> visitor) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@Override protected List<T> tryToExecuteActionReturnListHook() throws SQLException {
		return visitorMerge.executeTransformation(records);
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
