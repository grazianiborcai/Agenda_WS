package br.com.gda.business.phone.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class PhoneCopyPayCusRef extends InfoCopierTemplate<PhoneInfo, PaycusInfo>{
	
	public PhoneCopyPayCusRef() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(PaycusInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhoneRef;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
