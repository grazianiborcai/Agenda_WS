package br.com.mind5.business.masterData.info.common;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum UserCateg {
	OWNER('O', true), 
	STORE('S', true), 
	CUSTOMER('C', true), 
	EMPLOYEE('E', true),
	DAEMON('D', false);
	
	private final char codCateg;
	private final boolean isPasswordEnabled;
	
	
	private UserCateg(char cod, boolean isPassword) {
		codCateg = cod;
		isPasswordEnabled = isPassword;
	}
	
	
	
	public char getCodUserCateg() {
		return codCateg;
	}



	public boolean isPasswordEnabled() {
		return isPasswordEnabled;
	}
	
	
	
	static public UserCateg getUserCateg(char cod) {
		for(UserCateg eachElem : UserCateg.values()) {
			if (eachElem.getCodUserCateg() == cod)
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(UserCateg.class, e);
	}
}
