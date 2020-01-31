package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonapMergerCountryPhone extends InfoMergerTemplate_<PhonapInfo, CountryPhoneInfo> {

	@Override protected InfoMergerVisitor_<PhonapInfo, CountryPhoneInfo> getVisitorHook() {
		return new PhonapVisiMergeCountryPhone();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
