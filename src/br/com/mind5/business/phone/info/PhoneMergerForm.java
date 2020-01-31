package br.com.mind5.business.phone.info;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneMergerForm extends InfoMergerTemplate_<PhoneInfo, FormPhoneInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, FormPhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
