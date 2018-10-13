package br.com.gda.business.masterData.info;

public enum CartCateg {
	ITEM('I'), TOTAL('T'), SERVICE_FEE('S');
	
	private char codCateg;
	
	
	private CartCateg(char cod) {
		codCateg = cod;
	}
	
	
	
	public char getCodCateg() {
		return codCateg;
	}
}
