package br.com.gda.business.masterData.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StateMergerCountry extends InfoMergerTemplate<StateInfo, CountryInfo> {

	@Override protected InfoMergerVisitorV2<StateInfo, CountryInfo> getVisitorHook() {
		return new StateVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<StateInfo> getUniquifierHook() {
		return new StateUniquifier();
	}
}
