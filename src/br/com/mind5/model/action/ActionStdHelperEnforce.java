package br.com.mind5.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class ActionStdHelperEnforce<T extends InfoRecord> extends ActionStdTemplateV1<T> {
	private List<T> records = new ArrayList<>();
	private ActionVisitorEnforce<T> visitorEnforce;
	
	
	public ActionStdHelperEnforce(T recordInfo, ActionVisitorEnforce<T> visitor) {		
		super();
		checkArgument(recordInfo, visitor);
		makeCopy(recordInfo);
		visitorEnforce = visitor;
	}
	
	
	
	private void makeCopy(T recordInfo) {
		T cloned = super.makeDefensiveCopy(recordInfo);
		records.add(cloned);
	}
	
	
	
	public ActionStdHelperEnforce(List<T> recordInfos, ActionVisitorEnforce<T> visitor) {
		super();
		checkArgument(recordInfos, visitor);
		makeCopy(recordInfos);
		visitorEnforce = visitor;
	}
	
	
	
	private void makeCopy(List<T> recordInfos) {
		records = super.makeDefensiveCopy(recordInfos);
	}
	
	
	
	private void checkArgument(List<T> recordInfos, ActionVisitorEnforce<T> visitor) {
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
	
	
	
	private void checkArgument(T recordInfo, ActionVisitorEnforce<T> visitor) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (visitor == null) {
			logException(new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("visitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@Override protected List<T> tryToExecuteActionReturnListHook() throws SQLException {
		return visitorEnforce.executeTransformation(records);
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
