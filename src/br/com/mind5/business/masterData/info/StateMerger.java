package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class StateMerger {	
	public static StateInfo mergeWithCountry(CountryInfo sourceOne, StateInfo sourceTwo) {
		InfoMerger_<StateInfo, CountryInfo> merger = new StateMergerCountry();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StateInfo> mergeWithCountry(List<CountryInfo> sourceOnes, List<StateInfo> sourceTwos) {
		InfoMerger_<StateInfo, CountryInfo> merger = new StateMergerCountry();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
