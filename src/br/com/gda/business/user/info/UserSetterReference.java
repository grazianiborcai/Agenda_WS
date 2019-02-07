package br.com.gda.business.user.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class UserSetterReference implements InfoSetter<UserInfo> {
	
	public UserInfo setAttr(UserInfo recordInfo) {
		checkArgument(recordInfo);
		return setReference(recordInfo);
	}
	
	
	
	private void checkArgument(UserInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UserInfo setReference(UserInfo recordInfo) {
		recordInfo.codPerson = DefaultValue.number();
		recordInfo.codCustomer = DefaultValue.number();
		recordInfo.personData = setRefPerson(recordInfo.personData);
		recordInfo.addresses = setRefAddresses(recordInfo.addresses);
		recordInfo.phones = setRefPhones(recordInfo.phones);
		
		
		return recordInfo;
	}
	
	
	
	private PersonInfo setRefPerson(PersonInfo recordInfo) {
		if (recordInfo == null)
			return recordInfo;
		
		recordInfo.codPerson = DefaultValue.number();
		return recordInfo;
	}
	
	
	
	private List<AddressInfo> setRefAddresses(List<AddressInfo> recordInfos) {
		if (recordInfos == null)
			return recordInfos;
		
		if (recordInfos.isEmpty())
			return recordInfos;
		
		
		List<AddressInfo> results = new ArrayList<>();
		
		for (AddressInfo eachRecord : recordInfos) {
			eachRecord.codAddress = DefaultValue.number();
			results.add(eachRecord);
		}
		
		
		return results;
	}
	
	
	
	private List<PhoneInfo> setRefPhones(List<PhoneInfo> recordInfos) {
		if (recordInfos == null)
			return recordInfos;
		
		if (recordInfos.isEmpty())
			return recordInfos;
		
		
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PhoneInfo eachRecord : recordInfos) {
			eachRecord.codPhone = DefaultValue.number();
			results.add(eachRecord);
		}
		
		
		return results;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
