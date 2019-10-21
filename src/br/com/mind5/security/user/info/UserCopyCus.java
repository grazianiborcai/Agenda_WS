package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyCus extends InfoCopierTemplate<UserInfo, CusInfo>{
	
	public UserCopyCus() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(CusInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codPerson = source.codPerson;	
		result.codUser = source.codUser;
		result.codAuthGroup = source.codAuthGroup;
		result.codLanguage = source.codLanguage;
		result.codUserCategory = source.codUserCategory;
		result.username = source.username;
		
		result.personData = clonePerson(source.personData);
		result.addresses = cloneAddresses(source.addresses);
		result.phones = clonePhones(source.phones);
		
		return result;
	}
	
	
	
	private PersonInfo clonePerson(PersonInfo recordInfo) {
		try {
			if (recordInfo == null)
				return null;
			
			return (PersonInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private List<AddressInfo> cloneAddresses(List<AddressInfo> recordInfos) {
		try {
			if (recordInfos == null)
				return null;
			
			if (recordInfos.isEmpty())
				return Collections.emptyList();
			
			
			List<AddressInfo> clones = new ArrayList<>();
			
			for (AddressInfo eachRecord : recordInfos) {
				AddressInfo cloned = (AddressInfo) eachRecord.clone();
				clones.add(cloned);
			}
			
			return clones;
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private List<PhoneInfo> clonePhones(List<PhoneInfo> recordInfos) {
		try {
			if (recordInfos == null)
				return null;
			
			if (recordInfos.isEmpty())
				return Collections.emptyList();
			
			
			List<PhoneInfo> clones = new ArrayList<>();
			
			for (PhoneInfo eachRecord : recordInfos) {
				PhoneInfo cloned = (PhoneInfo) eachRecord.clone();
				clones.add(cloned);
			}
			
			return clones;
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
