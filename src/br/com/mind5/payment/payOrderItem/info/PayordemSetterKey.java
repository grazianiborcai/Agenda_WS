package br.com.mind5.payment.payOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PayordemSetterKey implements InfoSetter<PayordemInfo> {
	
	public PayordemInfo setAttr(PayordemInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(PayordemInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PayordemInfo setKey(PayordemInfo recordInfo) {
		PayordemInfo enforcedInfo = new PayordemInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codPayOrder = recordInfo.codPayOrder;
		enforcedInfo.codLanguage = recordInfo.codLanguage;	
		return enforcedInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
