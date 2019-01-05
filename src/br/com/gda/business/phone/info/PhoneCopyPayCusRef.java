package br.com.gda.business.phone.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

final class PhoneCopyPayCusRef extends InfoCopierTemplate<PhoneInfo, PayCusInfo>{
	
	public PhoneCopyPayCusRef() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(PayCusInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhoneRef;
		result.codUser = source.codUser;
		return result;
	}
}
