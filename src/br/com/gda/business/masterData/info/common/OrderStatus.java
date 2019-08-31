package br.com.gda.business.masterData.info.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public enum OrderStatus {
	CANCELLED("CANCELLED"),
	CREATED("CREATED"), 
	NOT_PAID("NOT_PAID"),
	PAID("PAID"), 
	PLACED("PLACED"), 
	REFUNDING("REFUNDING"), 
	WAITING("WAITING");
	
	
	private final String codStatus;
	
	
	private OrderStatus(String cod) {
		codStatus = cod;
	}
	
	
	
	public String getCodStatus() {
		return codStatus;
	}
	
	
	
	static public OrderStatus getOrderStatus(String cod) {
		if (cod == null)
			return null;
		
		
		for(OrderStatus eachElem : OrderStatus.values()) {
			if (eachElem.getCodStatus().equals(cod))
				return eachElem;
		}
		
		
		logException(new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND));
		throw new IllegalArgumentException(SystemMessage.ARGUMENT_NOT_FOUND);
	}
	
	
	
	static private void logException(Exception e) {
		Logger logger = LogManager.getLogger(OrderStatus.class);
		logger.error(e.getMessage(), e);
	}
}
