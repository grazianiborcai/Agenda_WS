package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class StateMergerCountry extends InfoMerger<StateInfo, CountryInfo, StateInfo> {
	public StateInfo merge(CountryInfo sourceOne, StateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StateVisiCountry());
	}
	
	
	
	public List<StateInfo> merge(List<CountryInfo> sourceOnes, List<StateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StateVisiCountry());
	}
}
