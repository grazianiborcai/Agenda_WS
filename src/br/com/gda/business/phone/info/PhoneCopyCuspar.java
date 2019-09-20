package br.com.gda.business.phone.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.customerPartner.info.CusparInfo;

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
