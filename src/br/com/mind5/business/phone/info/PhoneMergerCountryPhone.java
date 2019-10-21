package br.com.mind5.business.phone.info;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhoneMergerCountryPhone extends InfoMergerTemplate<PhoneInfo, CountryPhoneInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, CountryPhoneInfo> getVisitorHook() {
		return new PhoneVisiMergeCountryPhone();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
