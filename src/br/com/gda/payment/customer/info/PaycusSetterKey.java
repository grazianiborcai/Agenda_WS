package br.com.gda.payment.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PaycusSetterKey implements InfoSetter<PaycusInfo> {
	
	public PaycusInfo setAttr(PaycusInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(PaycusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PaycusInfo setKey(PaycusInfo recordInfo) {
		PaycusInfo result = new PaycusInfo();
		result.codOwner = recordInfo.codOwner;
		result.codUser = recordInfo.codUser;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		return result;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
