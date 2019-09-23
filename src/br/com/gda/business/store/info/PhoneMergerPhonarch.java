package br.com.gda.business.store.info;

import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PhoneMergerPhonarch extends InfoMergerTemplate<PhoneInfo, PhonarchInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, PhonarchInfo> getVisitorHook() {
		return new PhoneVisiMergePhonarch();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
