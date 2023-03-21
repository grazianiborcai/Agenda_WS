package br.com.mind5.masterData.common;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum OrderStatusPagarme {
	CREATED("CREATED", true, false, false, true),
	FAILED("FAILED", false, false, true, false),
	NOT_PAID("NOT_PAID", false, false, true, false),
	PAID("PAID", true, true, false, false),	 
	REVERTED("REVERTED", false, false, true, false),
	WAITING("WAITING", true, false, false, true);
	
	
	private final String codStatus;
	private final boolean isChangeable;
	private final boolean isPaid;
	private final boolean isNotPaid;
	private final boolean isOnWait;
	
	
	private OrderStatusPagarme(String cod, boolean change, boolean paid, boolean notPaid, boolean wait) {
		codStatus = cod;
		isChangeable = change;
		isPaid = paid;
		isNotPaid = notPaid;
		isOnWait = wait;	
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}



	public boolean isChangeable() {
		return isChangeable;
	}
	
	
	
	public boolean isPaid() {
		return isPaid;
	}
	
	
	
	public boolean isNotPaid() {
		return isNotPaid;
	}
	
	
	
	public boolean isOnWait() {
		return isOnWait;
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
