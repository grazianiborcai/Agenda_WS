package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PhonarchCopyCuspar extends InfoCopierTemplate<PhonarchInfo, CusparInfo> {
	
	public PhonarchCopyCuspar() {
		super();
	}
	
	
	
	@Override protected PhonarchInfo makeCopyHook(CusparInfo source) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhone;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
