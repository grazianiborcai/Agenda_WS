package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyEmp extends InfoCopierTemplate<UserInfo, EmpInfo>{
	
	public UserCopyEmp() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(EmpInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codPerson = source.codPerson;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		result.addresses = cloneAddresses(source.addresses);
		result.phones = clonePhones(source.phones);
		
		return result;
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
		
		SystemLog.logError(this.getClass(), e);
	}
}
