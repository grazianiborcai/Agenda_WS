package br.com.mind5.business.phone.info;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhoneMergerForm extends InfoMergerTemplate<PhoneInfo, FormPhoneInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, FormPhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
