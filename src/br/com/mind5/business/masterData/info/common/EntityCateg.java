package br.com.mind5.business.masterData.info.common;

public enum EntityCateg {
	CUSTOMER("C"), USER("U"), PAY_CUSTOMER("Y"), OWNER("O"), STORE("S"), EMPLOYEE("E");

	private final String codStringCateg;
	
	
	private EntityCateg (String cod) {
		codStringCateg = cod;
	}
	
	
	
	public String getCodEntityCateg() {
		return codStringCateg;
	}
}
