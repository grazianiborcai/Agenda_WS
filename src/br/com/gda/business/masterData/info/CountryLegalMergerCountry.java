package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class CountryLegalMergerCountry extends InfoMerger<CountryLegalInfo, CountryInfo, CountryLegalInfo> {
	public CountryLegalInfo merge(CountryInfo sourceOne, CountryLegalInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CountryLegalVisiCountry());
	}
	
	
	
	public List<CountryLegalInfo> merge(List<CountryInfo> sourceOnes, List<CountryLegalInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CountryLegalVisiCountry());
	}
}
