package br.com.mind5.masterData.common;

public enum Refupo {
	BEFORE_24_HOURS(1);
	
	private final int codRefundPolicy;
	
	
	private Refupo(int cod) {
		codRefundPolicy = cod;
	}
	
	
	
	public int getRefundPolicy() {
		return codRefundPolicy;
	}
}
