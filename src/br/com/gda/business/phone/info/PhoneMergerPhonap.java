package br.com.gda.business.phone.info;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PhoneMergerPhonap extends InfoMergerTemplate<PhoneInfo, PhonapInfo> {

	@Override protected InfoMergerVisitorV2<PhoneInfo, PhonapInfo> getVisitorHook() {
		return new PhoneVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
