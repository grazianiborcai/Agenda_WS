package br.com.gda.business.phone.info;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PhoneMergerCountryPhone extends InfoMergerTemplate<PhoneInfo, CountryPhoneInfo> {

	@Override protected InfoMergerVisitorV2<PhoneInfo, CountryPhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeCountryPhone();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
