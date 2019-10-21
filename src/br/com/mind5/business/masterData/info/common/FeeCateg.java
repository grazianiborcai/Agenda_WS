package br.com.mind5.business.masterData.info.common;

public enum FeeCateg {
	SERVICE('S');
	
	private char codCateg;
	
	
	private FeeCateg(char cod) {
		codCateg = cod;
	}
	
	
	
	public char getCodCateg() {
		return codCateg;
	}
}
