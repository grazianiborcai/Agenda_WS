package br.com.mind5.business.phone.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhoneCopyOwner extends InfoCopierTemplate<PhoneInfo, OwnerInfo> {
	
	public PhoneCopyOwner() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(OwnerInfo source) {
		PhoneInfo result = new PhoneInfo();
		
		result.codOwner = source.codOwner;
		result.codOwnerRef = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
