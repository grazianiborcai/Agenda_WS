package br.com.gda.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public final class ActionStdHelperEnforce<T> extends ActionStdTemplate<T> {
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
		if (recordInfos == null)
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		
		
		if (recordInfos.isEmpty())
			throw new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (T eachRecord : recordInfos) {
			checkArgument(eachRecord, visitor);
		}
	}
	
	
	
	private void checkArgument(T recordInfo, ActionVisitorEnforce<T> visitor) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override protected List<T> tryToExecuteActionListHook() throws SQLException {
		return visitorEnforce.executeTransformation(records);
	}
}
