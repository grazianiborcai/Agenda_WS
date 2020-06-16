package br.com.mind5.masterData.common;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;

public enum OrderStatusMoip {
	CREATED("CREATED", true, false, false, true), 
	WAITING("WAITING", true, false, false, true), 
	PAID("PAID", true, true, false, false), 
	NOT_PAID("NOT_PAID", false, false, true, false), 
	REVERTED("REVERTED", false, false, true, false);
	
	
	private final String codStatus;
	private final boolean isChangeable;
	private final boolean isPaid;
	private final boolean isNotPaid;
	private final boolean isOnWait;
	
	
	private OrderStatusMoip(String cod, boolean change, boolean paid, boolean notPaid, boolean wait) {
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
	
	
	
	static public OrderStatusMoip getStatus(String cod) {
		for(OrderStatusMoip eachElem : OrderStatusMoip.values()) {
			if (eachElem.getCodStatus().equals(cod))
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(OrderStatusMoip.class, e);
	}
}
