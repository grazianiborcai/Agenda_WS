package br.com.mind5.masterData.userCategory.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum Usereg {
	OWNER('O', true), 
	STORE('S', true), 
	CUSTOMER('C', true), 
	EMPLOYEE('E', true),
	DAEMON('D', false);
	
	private final char codCateg;
	private final boolean isPasswordEnabled;
	
	
	private Usereg(char cod, boolean isPassword) {
		codCateg = cod;
		isPasswordEnabled = isPassword;
	}
	
	
	
	public char getCodUserCateg() {
		return codCateg;
	}



	public boolean isPasswordEnabled() {
		return isPasswordEnabled;
	}
	
	
	
	static public Usereg getUserCateg(char cod) {
		for(Usereg eachElem : Usereg.values()) {
			if (eachElem.getCodUserCateg() == cod)
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(Usereg.class, e);
	}
}
