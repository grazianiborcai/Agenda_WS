package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public abstract class ActionVisitorTemplatePruneSelfV1<T extends InfoRecord> implements ActionVisitorPrune_<T> {	
		
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
		SystemLog.logError(this.getClass(), e);
	}
}
