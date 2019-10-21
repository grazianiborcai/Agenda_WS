package br.com.mind5.business.masterData.info.common;

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
