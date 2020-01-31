package br.com.mind5.business.phone.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneMergerPhonap extends InfoMergerTemplate_<PhoneInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, PhonapInfo> getVisitorHook() {
		return new PhoneVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
