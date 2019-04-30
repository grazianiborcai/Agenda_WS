package br.com.gda.business.phone.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PhoneCopyOwner extends InfoCopierTemplate<PhoneInfo, OwnerInfo>{
	
	public PhoneCopyOwner() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(OwnerInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codOwnerRef = source.codOwner;
		result.lastChangedBy = source.lastChangedBy;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
