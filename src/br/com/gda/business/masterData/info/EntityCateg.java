package br.com.gda.business.masterData.info;

public enum EntityCateg {
	CUSTOMER("C"), USER("U"), PAY_CUSTOMER("Y"), OWNER("O");

	private final String codStringCateg;
	
	
	private EntityCateg (String cod) {
		codStringCateg = cod;
	}
	
	
	
	public String getCodEntityCateg() {
		return codStringCateg;
	}
}
