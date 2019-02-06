package br.com.gda.business.user.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UserCopyOwner extends InfoCopierTemplate<UserInfo, OwnerInfo>{
	
	public UserCopyOwner() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(OwnerInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		//result.codPerson = source.codPerson;	//TODO: removido - verificar se possivel manter
		result.codLanguage = source.codLanguage;
		
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
