package br.com.gda.business.masterData.info;

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
