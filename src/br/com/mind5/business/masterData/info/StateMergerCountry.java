package br.com.mind5.business.masterData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StateMergerCountry extends InfoMergerTemplate_<StateInfo, CountryInfo> {

	@Override protected InfoMergerVisitor_<StateInfo, CountryInfo> getVisitorHook() {
		return new StateVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<StateInfo> getUniquifierHook() {
		return new StateUniquifier();
	}
}
