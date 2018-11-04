package br.com.gda.model.action.commom;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;
import br.com.gda.model.action.ActionVisitorEnforce;

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
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private T makeClone(T recordInfo) {
		try {
			return (T) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	@SuppressWarnings("unused")
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
