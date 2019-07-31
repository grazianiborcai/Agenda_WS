package br.com.gda.business.masterData.info.common;

public enum OrderStatus {
	CANCELLED("CANCELLED"),
	CREATED("CREATED"), 
	NOT_PAID("NOT_PAID"),
	PAID("PAID"), 
	WAITING("WAITING");
	
	
	private final String codStatus;
	
	
	private OrderStatus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
}
