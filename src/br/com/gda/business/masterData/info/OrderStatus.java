package br.com.gda.business.masterData.info;

public enum OrderStatus {
	CREATED("CREATED"), WAITING("WAITING"), PAID("PAID"), NOT_PAID("NOT_PAID"), CANCELLED("CANCELLED");
	
	
	private final String codOrderStatus;
	
	
	private OrderStatus(String cod) {
		codOrderStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codOrderStatus;
	}
}
