package br.com.gda.business.masterData.info.common;

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
}
