package br.com.mind5.business.masterData.info.common;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum MatUnit {
	EACH("EAC"), MINUTE("MIN"), HOUR("H");
	
	
	private String codUnit;
	
	
	private MatUnit(String cod) {
		codUnit = cod;
	}
	
	
	
	public String getCodUnit() {
		return codUnit;
	}
	
	
	
	static public MatUnit getMatUnit(String cod) {
		for(MatUnit eachElem : MatUnit.values()) {
			if (eachElem.getCodUnit().equals(cod))
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(MatUnit.class, e);
	}
}
