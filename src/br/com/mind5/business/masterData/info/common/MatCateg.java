package br.com.mind5.business.masterData.info.common;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum MatCateg {
	PRODUCT(1), SERVICE(2);	
	
	private final int codMatCateg;
	
	
	private MatCateg(int cod) {
		codMatCateg = cod;
	}
	
	
	
	public int getCodMatCateg() {
		return codMatCateg;
	}
	
	
	
	static public MatCateg getMatCateg(int cod) {
		for(MatCateg eachElem : MatCateg.values()) {
			if (eachElem.getCodMatCateg() == cod)
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(MatCateg.class, e);
	}
}
