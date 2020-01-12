package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhonarchCopyPhoneRef extends InfoCopierTemplate<PhonarchInfo, PhoneInfo>{
	
	public PhonarchCopyPhoneRef() {
		super();
	}
	
	
	
	@Override protected PhonarchInfo makeCopyHook(PhoneInfo source) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.codUser = source.codUser;
		result.codOwnerRef = source.codOwnerRef;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
