package br.com.mind5.business.phone.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhoneCopyStolis extends InfoCopierTemplate<PhoneInfo, StolisInfo>{
	
	public PhoneCopyStolis() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(StolisInfo source) {
		PhoneInfo result = new PhoneInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
