package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PayCusSetterPhoneKey implements InfoSetter<PayCusInfo> {
	
	public PayCusInfo setAttr(PayCusInfo recordInfo) {
		checkArgument(recordInfo);
		return setPhoneKey(recordInfo);
	}
	
	
	
	private void checkArgument(PayCusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PayCusInfo setPhoneKey(PayCusInfo recordInfo) {
		if (recordInfo.phone == null)
			return recordInfo;
		
		recordInfo.phone.codOwner = recordInfo.codOwner;
		recordInfo.phone.codPayCustomer = recordInfo.codPayCustomer;		
		recordInfo.phone.codPhone = DefaultValue.number();
		recordInfo.phone.codCustomer = DefaultValue.number();
		recordInfo.phone.codStore = DefaultValue.number();
		recordInfo.phone.codEmployee = DefaultValue.number();
		recordInfo.phone.codUser = DefaultValue.number();
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
