package br.com.mind5.business.phone.info;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneMergerPhonarch extends InfoMergerTemplate_<PhoneInfo, PhonarchInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, PhonarchInfo> getVisitorHook() {
		return new PhoneVisiMergePhonarch();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
