package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
final class PhoneCopyCusmoip extends InfoCopierTemplate<PhoneInfo, CusmoipInfo>{
	
	public PhoneCopyCusmoip() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(CusmoipInfo source) {
		PhoneInfo result = new PhoneInfo();
		
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhone;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
