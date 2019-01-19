package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PaycusSetterPersonKey implements InfoSetter<PaycusInfo> {
	
	public PaycusInfo setAttr(PaycusInfo recordInfo) {
		checkArgument(recordInfo);
		return setPersonKey(recordInfo);
	}
	
	
	
	private void checkArgument(PaycusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PaycusInfo setPersonKey(PaycusInfo recordInfo) {		
		recordInfo.codPerson = DefaultValue.number();		
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
