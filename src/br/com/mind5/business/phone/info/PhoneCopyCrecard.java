package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PhoneCopyCrecard extends InfoCopierTemplate<PhoneInfo, CrecardInfo>{
	
	public PhoneCopyCrecard() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(CrecardInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhoneHolder;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
