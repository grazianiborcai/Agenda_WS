package br.com.mind5.business.phone.info;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneMergerCountryPhone extends InfoMergerTemplate_<PhoneInfo, CountryPhoneInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, CountryPhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeCountryPhone();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
