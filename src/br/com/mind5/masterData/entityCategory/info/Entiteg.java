package br.com.mind5.masterData.entityCategory.info;

public enum Entiteg {
	CUSTOMER("C"), USER("U"), PAY_CUSTOMER("Y"), OWNER("O"), STORE("S"), EMPLOYEE("E");

	private final String codStringCateg;
	
	
	private Entiteg (String cod) {
		codStringCateg = cod;
	}
	
	
	
	public String getCodEntityCateg() {
		return codStringCateg;
	}
}
