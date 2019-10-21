package br.com.mind5.business.masterData.info.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public enum MatmovType {
	INCOME('I', 1), OUTCOME('O', -1);
	
	
	private char codMatmovType;
	private int mathSign;
	
	
	private MatmovType(char cod, int sign) {
		codMatmovType = cod;
		mathSign = sign;
	}
	
	
	
	public char getCodMatmovType() {
		return codMatmovType;
	}
	
	
	
	public int getMathSign() {
		return mathSign;
	}
	
	
	
	static public MatmovType getMatmovType(char cod) {
		for(MatmovType eachElem : MatmovType.values()) {
			if (eachElem.getCodMatmovType() == cod)
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		Logger logger = LogManager.getLogger(MatmovType.class);
		logger.error(e.getMessage(), e);
	}
}
