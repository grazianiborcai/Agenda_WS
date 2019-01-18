package br.com.gda.business.masterData.info;

public enum PaymentStatus {
	CREATED("CREATED"), WAITING("WAITING"), PAID("PAID"), NOT_PAID("NOT_PAID"), CANCELLED("CANCELLED");
	
	
	private final String codStatus;
	
	
	private PaymentStatus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
}
