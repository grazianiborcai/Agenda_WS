package br.com.mind5.business.masterData.info.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		Logger logger = LogManager.getLogger(MatCateg.class);
		logger.error(e.getMessage(), e);
	}
}
