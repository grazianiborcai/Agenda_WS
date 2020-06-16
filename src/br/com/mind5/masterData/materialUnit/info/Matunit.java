package br.com.mind5.masterData.materialUnit.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum Matunit {
	EACH("EAC"), MINUTE("MIN"), HOUR("H");
	
	
	private String codUnit;
	
	
	private Matunit(String cod) {
		codUnit = cod;
	}
	
	
	
	public String getCodUnit() {
		return codUnit;
	}
	
	
	
	static public Matunit getMatUnit(String cod) {
		for(Matunit eachElem : Matunit.values()) {
			if (eachElem.getCodUnit().equals(cod))
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(Matunit.class, e);
	}
}
