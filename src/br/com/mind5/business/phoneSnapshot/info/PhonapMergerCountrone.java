package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;

final class PhonapMergerCountrone extends InfoMergerTemplate_<PhonapInfo, CountroneInfo> {

	@Override protected InfoMergerVisitor_<PhonapInfo, CountroneInfo> getVisitorHook() {
		return new PhonapVisiMergeCountrone();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
