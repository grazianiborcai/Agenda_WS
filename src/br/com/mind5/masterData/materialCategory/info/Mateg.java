package br.com.mind5.masterData.materialCategory.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum Mateg {
	PRODUCT(1), SERVICE(2);	
	
	private final int codMatCateg;
	
	
	private Mateg(int cod) {
		codMatCateg = cod;
	}
	
	
	
	public int getCodMatCateg() {
		return codMatCateg;
	}
	
	
	
	static public Mateg getMatCateg(int cod) {
		for(Mateg eachElem : Mateg.values()) {
			if (eachElem.getCodMatCateg() == cod)
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(Mateg.class, e);
	}
}
