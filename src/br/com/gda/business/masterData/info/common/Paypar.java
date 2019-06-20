package br.com.gda.business.masterData.info.common;

public enum Paypar {
	MOIP(1);
	
	private final int codPayPartner;
	
	
	private Paypar(int cod) {
		codPayPartner = cod;
	}
	
	
	
	public int getCodPayPartner() {
		return codPayPartner;
	}
}
