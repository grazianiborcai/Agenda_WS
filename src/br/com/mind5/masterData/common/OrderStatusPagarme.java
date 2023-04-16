package br.com.mind5.masterData.common;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum OrderStatusPagarme {
	CANCELED("CANCELED"),
	CREATED ("CREATED" ),
	FAILED  ("FAILED"  ),
	NOT_PAID("NOT_PAID"),
	PAID    ("PAID"    ),
	WAITING ("WAITING" );
	
	
	private final String codStatus;
	
	
	private OrderStatusPagarme(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
	
	
	
	static public OrderStatusPagarme getStatus(String cod) {
		if (cod == null)
			return null;
		
		String upperCod = cod.toUpperCase();
		
		for(OrderStatusPagarme eachElem : OrderStatusPagarme.values()) {
			if (eachElem.getCodStatus().equals(upperCod))
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(OrderStatusPagarme.class, e);
	}
}
