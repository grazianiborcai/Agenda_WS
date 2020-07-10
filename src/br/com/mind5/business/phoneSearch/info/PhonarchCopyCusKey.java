package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhonarchCopyCusKey extends InfoCopierTemplate<PhonarchInfo, CusInfo> {
	
	public PhonarchCopyCusKey() {
		super();
	}
	
	
	
	@Override protected PhonarchInfo makeCopyHook(CusInfo source) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
