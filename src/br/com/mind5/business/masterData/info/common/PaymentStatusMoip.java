package br.com.mind5.business.masterData.info.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public enum PaymentStatusMoip {
	AUTHORIZED("AUTHORIZED", true, true, false, false), 
	CANCELLED("CANCELLED", false, false, true, false),
	CREATED("CREATED", true, false, false, true), 
	IN_ANALYSIS("IN_ANALYSIS", true, false, false, true), 
	PRE_AUTHORIZED("PRE_AUTHORIZED", true , false, false, true), 
	REFUNDED("REFUNDED", false, true, false, false),
	REVERSED("REVERSED", false, false, true, false),
	SETTLED("SETTLED", false, true, false, false),
	WAITING("WAITING", true, false, false, true);
	
	
	private final String codStatus;
	private final boolean isChangeable;
	private final boolean isPaid;
	private final boolean isNotPaid;
	private final boolean isOnWait;
	
	
	private PaymentStatusMoip(String cod, boolean change, boolean paid, boolean notPaid, boolean wait) {
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
	
	
	
	static public PaymentStatusMoip getStatus(String cod) {
		for(PaymentStatusMoip eachElem : PaymentStatusMoip.values()) {
			if (eachElem.getCodStatus().equals(cod))
				return eachElem;
		}
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		Logger logger = LogManager.getLogger(PaymentStatusMoip.class);
		logger.error(e.getMessage(), e);
	}
}
