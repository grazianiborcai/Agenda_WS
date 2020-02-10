package br.com.mind5.business.phone.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhoneCopyCusKey extends InfoCopierTemplate<PhoneInfo, CusInfo>{
	
	public PhoneCopyCusKey() {
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
