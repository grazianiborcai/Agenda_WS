package br.com.mind5.business.masterData.info.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public enum ScheduleStatus {
	CANCELLED("CANCELLED"),
	CONFIRMED("CONFIRMED"), 
	WAITING("WAITING");
	
	
	private final String codStatus;
	
	
	private ScheduleStatus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
	
	
	
	static public ScheduleStatus getScheduleStatus(String cod) {
		if (cod == null)
			return null;
		
		
		for(ScheduleStatus eachElem : ScheduleStatus.values()) {
			if (eachElem.getCodStatus().equals(cod))
				return eachElem;
		}
		
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		Logger logger = LogManager.getLogger(ScheduleStatus.class);
		logger.error(e.getMessage(), e);
	}
}
