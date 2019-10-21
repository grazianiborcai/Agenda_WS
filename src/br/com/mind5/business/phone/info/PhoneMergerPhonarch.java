package br.com.mind5.business.phone.info;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhoneMergerPhonarch extends InfoMergerTemplate<PhoneInfo, PhonarchInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, PhonarchInfo> getVisitorHook() {
		return new PhoneVisiMergePhonarch();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
