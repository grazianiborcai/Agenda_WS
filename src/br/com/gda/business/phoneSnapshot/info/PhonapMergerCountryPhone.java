package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PhonapMergerCountryPhone extends InfoMergerTemplate<PhonapInfo, CountryPhoneInfo> {

	@Override protected InfoMergerVisitor<PhonapInfo, CountryPhoneInfo> getVisitorHook() {
		return new PhonapVisiMergeCountryPhone();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
