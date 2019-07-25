package br.com.gda.business.masterData.info.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public enum OrderStatusMoip {
	CREATED("CREATED", true), WAITING("WAITING", true), PAID("PAID", true), NOT_PAID("NOT_PAID", false), REVERTED("REVERTED", false);
	
	
	private final String codStatus;
	private final boolean isChangeable;
	
	
	private OrderStatusMoip(String cod, boolean change) {
		codStatus = cod;
		isChangeable = change;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}



	public boolean isChangeable() {
		return isChangeable;
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
		Logger logger = LogManager.getLogger(MatmovType.class);
		logger.error(e.getMessage(), e);
	}
}
