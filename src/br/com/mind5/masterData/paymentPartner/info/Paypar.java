package br.com.mind5.masterData.paymentPartner.info;

public enum Paypar {
	MOIP(1),
	PAGARME(2);
	
	private final int codPayPartner;
	
	
	private Paypar(int cod) {
		codPayPartner = cod;
	}
	
	
	
	public int getCodPayPartner() {
		return codPayPartner;
	}
}
