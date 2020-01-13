package br.com.mind5.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusSetterAddressKey implements InfoSetter<CusInfo> {
	
	public CusInfo setAttr(CusInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(CusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusInfo setAddressKey(CusInfo recordInfo) {
		for (AddressInfo eachRecord : recordInfo.addresses) {
			eachRecord.codOwner = recordInfo.codOwner;
			eachRecord.codCustomer = recordInfo.codCustomer;
			eachRecord.codStore = DefaultValue.number();
			eachRecord.codEmployee = DefaultValue.number();
			eachRecord.codUser = DefaultValue.number();
			eachRecord.codOwnerRef = DefaultValue.number();
			eachRecord.codLanguage = recordInfo.codLanguage;
			eachRecord.username = recordInfo.username;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
