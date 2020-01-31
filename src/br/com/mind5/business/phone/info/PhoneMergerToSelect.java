package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneMergerToSelect extends InfoMergerTemplate_<PhoneInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, PhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
