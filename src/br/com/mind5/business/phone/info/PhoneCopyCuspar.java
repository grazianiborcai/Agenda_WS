package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PhoneCopyCuspar extends InfoCopierTemplate<PhoneInfo, CusparInfo>{
	
	public PhoneCopyCuspar() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(CusparInfo source) {
		PhoneInfo result = new PhoneInfo();
		
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhone;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
