package br.com.mind5.masterData.paymentStatus.info;

public enum Paymenus {
	ACCEPTED("ACCEPTED"), 
	REFUSED("REFUSED"), 
	WAITING("WAITING");
	
	
	private final String codStatus;
	
	
	private Paymenus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
}
