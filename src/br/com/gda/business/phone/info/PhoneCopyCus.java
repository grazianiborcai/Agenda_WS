package br.com.gda.business.phone.info;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PhoneCopyCus extends InfoCopierTemplate<PhoneInfo, CusInfo>{
	
	public PhoneCopyCus() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(CusInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
