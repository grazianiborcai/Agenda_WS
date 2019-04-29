package br.com.gda.business.phone.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PhoneCopyStolis extends InfoCopierTemplate<PhoneInfo, StolisInfo>{
	
	public PhoneCopyStolis() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(StolisInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		return result;
	}
}
