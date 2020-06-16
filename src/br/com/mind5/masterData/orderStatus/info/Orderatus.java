package br.com.mind5.masterData.orderStatus.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum Orderatus {
	CANCELLED("CANCELLED"),
	CREATED("CREATED"), 
	NOT_PAID("NOT_PAID"),
	PAID("PAID"), 
	PLACED("PLACED"), 
	REFUNDING("REFUNDING"), 
	WAITING("WAITING");
	
	
	private final String codStatus;
	
	
	private Orderatus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
	
	
	
	static public Orderatus getOrderStatus(String cod) {
		if (cod == null)
			return null;
		
		
		for(Orderatus eachElem : Orderatus.values()) {
			if (eachElem.getCodStatus().equals(cod))
				return eachElem;
		}
		
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(Orderatus.class, e);
	}
}
