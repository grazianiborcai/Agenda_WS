package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneMergerToUpdate extends InfoMergerTemplate_<PhoneInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, PhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
