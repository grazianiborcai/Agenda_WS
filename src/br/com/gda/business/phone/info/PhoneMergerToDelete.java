package br.com.gda.business.phone.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PhoneMergerToDelete extends InfoMergerTemplate<PhoneInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, PhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
