package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PayCusSetterAddressKey implements InfoSetter<PayCusInfo> {
	
	public PayCusInfo setAttr(PayCusInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(PayCusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PayCusInfo setAddressKey(PayCusInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codCustomer = recordInfo.codPayCustomer;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
