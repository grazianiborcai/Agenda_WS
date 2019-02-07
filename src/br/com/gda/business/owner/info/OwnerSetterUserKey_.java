package br.com.gda.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OwnerSetterUserKey_ implements InfoSetter<OwnerInfo> {
	
	public OwnerInfo setAttr(OwnerInfo recordInfo) {
		checkArgument(recordInfo);
		return setUserKey(recordInfo);
	}
	
	
	
	private void checkArgument(OwnerInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OwnerInfo setUserKey(OwnerInfo recordInfo) {
		recordInfo = setPersonKey(recordInfo);
		recordInfo = setAddressKey(recordInfo);
		recordInfo = setPhoneKey(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private OwnerInfo setPersonKey(OwnerInfo recordInfo) {
		if (recordInfo.personData == null)
			return recordInfo;
		
		recordInfo.personData.codOwner = recordInfo.codOwner;
		recordInfo.personData.codPerson = DefaultValue.number();
		
		return recordInfo;
	}
	
	
	
	private OwnerInfo setAddressKey(OwnerInfo recordInfo) {
		if (recordInfo.addresses == null)
			return recordInfo;
		
		if (recordInfo.addresses.isEmpty())
			return recordInfo;
		
		
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codAddress = DefaultValue.number();
		}
		
		return recordInfo;
	}
	
	
	
	private OwnerInfo setPhoneKey(OwnerInfo recordInfo) {
		if (recordInfo.phones == null)
			return recordInfo;
		
		if (recordInfo.phones.isEmpty())
			return recordInfo;
		
		
		for (PhoneInfo eachPhone : recordInfo.phones) {
			eachPhone.codOwner = recordInfo.codOwner;
			eachPhone.codPhone = DefaultValue.number();
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
