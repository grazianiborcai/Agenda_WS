package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class StateMerger {	
	public static StateInfo mergeWithCountry(CountryInfo sourceOne, StateInfo sourceTwo) {
		InfoMerger<StateInfo, CountryInfo> merger = new StateMergerCountry();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StateInfo> mergeWithCountry(List<CountryInfo> sourceOnes, List<StateInfo> sourceTwos) {
		InfoMerger<StateInfo, CountryInfo> merger = new StateMergerCountry();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
