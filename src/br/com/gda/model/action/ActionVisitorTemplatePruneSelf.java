package br.com.gda.model.action;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public abstract class ActionVisitorTemplatePruneSelf<T extends InfoRecord> implements ActionVisitorPrune<T> {	
		
	@Override public List<T> executeTransformation(List<T> recordInfos) {
		if(shouldPrune(recordInfos))		
			return pruneHook(recordInfos);
		
		return recordInfos;
	}	
	
	
	
	private boolean shouldPrune(List<T> recordInfos) {
		if(recordInfos.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	protected List<T> pruneHook(List<T> recordInfos) {	
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}

	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
