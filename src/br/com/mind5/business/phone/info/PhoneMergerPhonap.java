package br.com.mind5.business.phone.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhoneMergerPhonap extends InfoMergerTemplate<PhoneInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, PhonapInfo> getVisitorHook() {
		return new PhoneVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
