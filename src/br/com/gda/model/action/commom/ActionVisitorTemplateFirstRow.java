package br.com.gda.model.action.commom;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.info.InfoRecord;
import br.com.gda.model.action.ActionVisitorEnforce;


public abstract class ActionVisitorTemplateFirstRow<T extends InfoRecord> implements ActionVisitorEnforce<T> {
	
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		List<T> resultRecords = new ArrayList<>();		
		
		resultRecords.add(makeClone(recordInfos.get(0)));		
		
		return resultRecords;
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
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
