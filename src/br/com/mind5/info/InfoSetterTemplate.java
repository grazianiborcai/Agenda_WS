package br.com.mind5.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public abstract class InfoSetterTemplate<T extends InfoRecord> implements InfoSetter<T> {
	
	@Override public T setAttr(T recordInfo) {
		checkArgument(recordInfo);
		
		return setAttrHook(recordInfo);
	}
	
	
	
	protected T setAttrHook(T recordInfo) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void checkArgument(T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	protected void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
