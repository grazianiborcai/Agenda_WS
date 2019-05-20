package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PhonapMergerCountryPhone extends InfoMergerTemplate<PhonapInfo, CountryPhoneInfo> {

	@Override protected InfoMergerVisitorV2<PhonapInfo, CountryPhoneInfo> getVisitorHook() {
		return new PhonapVisiMergeCountryPhone();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
