package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.EntityCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PayCusSetterCodEntityCateg implements InfoSetter<PayCusInfo> {
	
	public PayCusInfo setAttr(PayCusInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(PayCusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PayCusInfo setCodEntityCateg(PayCusInfo recordInfo) {
		recordInfo.codEntityCateg = EntityCateg.PAY_CUSTOMER.getCodEntityCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
