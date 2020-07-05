package br.com.mind5.masterData.common;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum UserCategory {
	ANONYMOUS('A', true),
	CUSTOMER('C', true),
	DAEMON('D', false),
	EMPLOYEE('E', true),
	OWNER('O', true), 
	STORE('S', true);
	
	private final char codCateg;
	private final boolean isPasswordEnabled;
	
	
	private UserCategory(char cod, boolean isPassword) {
		codCateg = cod;
		isPasswordEnabled = isPassword;
	}
	
	
	
	public char getCodUserCateg() {
		return codCateg;
	}



	public boolean isPasswordEnabled() {
		return isPasswordEnabled;
	}
	
	
	
	static public UserCategory getUserCateg(char cod) {
		for(UserCategory eachElem : UserCategory.values()) {
			if (eachElem.getCodUserCateg() == cod)
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(UserCategory.class, e);
	}
}
