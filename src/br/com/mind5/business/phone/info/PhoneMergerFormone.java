package br.com.mind5.business.phone.info;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneMergerFormone extends InfoMergerTemplate_<PhoneInfo, FormoneInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, FormoneInfo> getVisitorHook() {
		return new PhoneVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
