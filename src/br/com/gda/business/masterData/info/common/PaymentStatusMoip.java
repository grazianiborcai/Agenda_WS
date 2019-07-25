package br.com.gda.business.masterData.info.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public enum PaymentStatusMoip {
	AUTHORIZED("AUTHORIZED", true), 
	CANCELLED("CANCELLED", false),
	CREATED("CREATED", true), 
	IN_ANALYSIS("IN_ANALYSIS", true), 
	PRE_AUTHORIZED("PRE_AUTHORIZED", true), 
	REFUNDED("REFUNDED", false),
	REVERTED("REVERTED", false),
	SETTLED("SETTLED", false),
	WAITING("WAITING", true);
	
	
	private final String codStatus;
	private final boolean isChangeable;
	
	
	private PaymentStatusMoip(String cod, boolean change) {
		codStatus = cod;
		isChangeable = change;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}



	public boolean isChangeable() {
		return isChangeable;
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
		Logger logger = LogManager.getLogger(MatmovType.class);
		logger.error(e.getMessage(), e);
	}
}
