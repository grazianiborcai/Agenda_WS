package br.com.gda.business.phone.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class PhoneCopyPayord extends InfoCopierTemplate<PhoneInfo, PayordInfo>{
	
	public PhoneCopyPayord() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(PayordInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhonePay;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
