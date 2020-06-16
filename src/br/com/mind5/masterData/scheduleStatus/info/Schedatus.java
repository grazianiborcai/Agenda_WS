package br.com.mind5.masterData.scheduleStatus.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum Schedatus {
	CANCELLED("CANCELLED"),
	CONFIRMED("CONFIRMED"), 
	WAITING("WAITING");
	
	
	private final String codStatus;
	
	
	private Schedatus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
	
	
	
	static public Schedatus getScheduleStatus(String cod) {
		if (cod == null)
			return null;
		
		
		for(Schedatus eachElem : Schedatus.values()) {
			if (eachElem.getCodStatus().equals(cod))
				return eachElem;
		}
		
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(Schedatus.class, e);
	}
}
