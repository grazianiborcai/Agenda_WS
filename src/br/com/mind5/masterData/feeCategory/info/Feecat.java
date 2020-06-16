package br.com.mind5.masterData.feeCategory.info;

public enum Feecat {
	SERVICE('S');
	
	private char codCateg;
	
	
	private Feecat(char cod) {
		codCateg = cod;
	}
	
	
	
	public char getCodCateg() {
		return codCateg;
	}
}
