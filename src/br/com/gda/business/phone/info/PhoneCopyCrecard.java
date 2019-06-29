package br.com.gda.business.phone.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.creditCard.info.CrecardInfo;

final class PhoneCopyCrecard extends InfoCopierTemplate<PhoneInfo, CrecardInfo>{
	
	public PhoneCopyCrecard() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(CrecardInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhoneHolder;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
