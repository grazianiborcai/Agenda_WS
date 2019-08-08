package br.com.gda.business.phone.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PhoneMergerToSelect extends InfoMergerTemplate<PhoneInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, PhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
