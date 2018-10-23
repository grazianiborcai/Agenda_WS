package br.com.gda.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public abstract class ActionVisitorTemplateFilter<T extends InfoRecord> implements ActionVisitorEnforce<T> {	
	protected boolean KEEP_RECORD = false;
	protected boolean SKIP_RECORD = true;
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		List<T> resultRecords = new ArrayList<>();		
		
		for (T eachRecord : recordInfos) {
			if (filterOut(eachRecord) == KEEP_RECORD)
				resultRecords.add(eachRecord);
		}
		
		return resultRecords;
	}
	
	
	
	private boolean filterOut(T recordInfo) {
		T clonedInfo = makeClone(recordInfo);
		return filterOutHook(clonedInfo);
	}
	
	
	
	protected boolean filterOutHook(T recordInfo) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private T makeClone(T recordInfo) {
		try {
			return (T) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
