package br.com.mind5.masterData.common;

public enum Refugrader {
	BEFORE_24_HOURS(1);
	
	private final int codRefundPolicyGroup;
	
	
	private Refugrader(int cod) {
		codRefundPolicyGroup = cod;
	}
	
	
	
	public int getCodRefundPolicyGroup() {
		return codRefundPolicyGroup;
	}
}
