package br.com.gda.business.masterData.info.common;

public enum UserCateg {
	OWNER('O'), STORE('S'), CUSTOMER('C'), EMPLOYEE('E');
	
	private char codCateg;
	
	
	private UserCateg(char cod) {
		codCateg = cod;
	}
	
	
	
	public char getCodUserCateg() {
		return codCateg;
	}
}
