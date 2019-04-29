package br.com.gda.payService.payCustomer.info;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class PaycusVisiUser implements InfoMergerVisitor_<PaycusInfo, UserInfo, PaycusInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public PaycusInfo writeRecord(UserInfo sourceOne, PaycusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaycusInfo copyInfo = PaycusInfo.copyFrom(sourceOne);
		copyInfo.codPayPartner = sourceTwo.codPayPartner;
		copyInfo.txtPayPartner = sourceTwo.txtPayPartner;
		copyInfo.codPayCustomer = sourceTwo.codPayCustomer;
		copyInfo.codPerson = sourceTwo.codPerson;
		copyInfo.codPhoneRef = sourceTwo.codPhoneRef;
		copyInfo.codAddressRef = sourceTwo.codAddressRef;
		copyInfo.codPersonRef = sourceOne.codPerson;
		copyInfo.address = cloneAddress(sourceOne.addresses, sourceTwo);
		copyInfo.phone = clonePhone(sourceOne.phones, sourceTwo);
		return copyInfo;
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, PaycusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddressInfo cloneAddress(List<AddressInfo> addresses, PaycusInfo sourceTwo) {
		AddressInfo result = new AddressInfo();
		
		for (AddressInfo eachAddress : addresses) {
			if (checkAddress(eachAddress, sourceTwo) == SUCCESS)
				result = makeClone(eachAddress);
		}		
		
		return result;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PhoneInfo clonePhone(List<PhoneInfo> phones, PaycusInfo sourceTwo) {
		PhoneInfo result = new PhoneInfo();
		
		for (PhoneInfo eachPhone : phones) {
			if (checkPhone(eachPhone, sourceTwo) == SUCCESS)
				result = makeClone(eachPhone);
		}		
		
		return result;
	}
	
	
	
	private PhoneInfo makeClone(PhoneInfo recordInfo) {
		try {
			return (PhoneInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(UserInfo sourceOne, PaycusInfo sourceTwo) {
		if (checkUser(sourceOne, sourceTwo) == FAILED)
			return FAILED;
		
		
		if (checkAddresses(sourceOne.addresses, sourceTwo) == FAILED)
			return FAILED;
			
		
		if (checkPhones(sourceOne.phones, sourceTwo) == FAILED)
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkUser(UserInfo user, PaycusInfo sourceTwo) {
		if (user.codOwner 	== sourceTwo.codOwner	&& 
			user.codUser 	== sourceTwo.codUser		) 
				return SUCCESS;
		
		return FAILED;
	}
	
	
	
	private boolean checkAddresses(List<AddressInfo> addresses, PaycusInfo sourceTwo) {
		for (AddressInfo eachAddress : addresses) {
			if (checkAddress(eachAddress, sourceTwo) == SUCCESS)
				return SUCCESS;
		}
		
		return FAILED;
	}
	
	
	
	private boolean checkAddress(AddressInfo address, PaycusInfo sourceTwo) {
		if (address.codOwner	== sourceTwo.codOwner		&&
			address.codAddress	== sourceTwo.codAddressRef		)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	private boolean checkPhones(List<PhoneInfo> phones, PaycusInfo sourceTwo) {
		for (PhoneInfo eachPhone : phones) {
			if (checkPhone(eachPhone, sourceTwo) == SUCCESS)
				return SUCCESS;
		}
		
		return FAILED;
	}
	
	
	
	private boolean checkPhone(PhoneInfo phone, PaycusInfo sourceTwo) {
		if (phone.codOwner	== sourceTwo.codOwner		&&
			phone.codPhone	== sourceTwo.codPhoneRef		)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
