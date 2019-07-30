package br.com.gda.business.masterData.info.common;

public enum PaymentStatus {
	AUTHORIZED("AUTHORIZED"), ACCEPTED("ACCEPTED"), REFUSED("REFUSED"), WAITING("WAITING");
	
	
	private final String codStatus;
	
	
	private PaymentStatus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
}
