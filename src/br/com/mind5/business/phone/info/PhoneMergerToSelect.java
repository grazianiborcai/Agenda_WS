package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhoneMergerToSelect extends InfoMergerTemplate<PhoneInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, PhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
