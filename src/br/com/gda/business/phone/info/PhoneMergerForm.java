package br.com.gda.business.phone.info;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PhoneMergerForm extends InfoMergerTemplate<PhoneInfo, FormPhoneInfo> {

	@Override protected InfoMergerVisitorV2<PhoneInfo, FormPhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
