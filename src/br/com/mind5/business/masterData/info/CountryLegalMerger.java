package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class CountryLegalMerger {	
	public static CountryLegalInfo mergeWithCountry(CountryInfo sourceOne, CountryLegalInfo sourceTwo) {
		InfoMerger<CountryLegalInfo, CountryInfo> merger = new CountryLegalMergerCountry();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CountryLegalInfo> mergeWithCountry(List<CountryInfo> sourceOnes, List<CountryLegalInfo> sourceTwos) {
		InfoMerger<CountryLegalInfo, CountryInfo> merger = new CountryLegalMergerCountry();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
