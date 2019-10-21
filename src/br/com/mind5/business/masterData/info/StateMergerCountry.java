package br.com.mind5.business.masterData.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StateMergerCountry extends InfoMergerTemplate<StateInfo, CountryInfo> {

	@Override protected InfoMergerVisitor<StateInfo, CountryInfo> getVisitorHook() {
		return new StateVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<StateInfo> getUniquifierHook() {
		return new StateUniquifier();
	}
}
