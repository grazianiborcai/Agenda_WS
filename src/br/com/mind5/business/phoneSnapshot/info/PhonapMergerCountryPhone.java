package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhonapMergerCountryPhone extends InfoMergerTemplate<PhonapInfo, CountryPhoneInfo> {

	@Override protected InfoMergerVisitor<PhonapInfo, CountryPhoneInfo> getVisitorHook() {
		return new PhonapVisiMergeCountryPhone();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
