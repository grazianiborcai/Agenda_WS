package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory_;

public final class CountryLegalMerger extends InfoWritterFactory_<CountryLegalInfo> {	
	
	public CountryLegalMerger() {
		super(new CountryLegalUniquifier());
	}
	
	
	
	static public CountryLegalInfo merge(CountryInfo sourceOne, CountryLegalInfo sourceTwo) {
		return new CountryLegalMergerCountry().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CountryLegalInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {				
		if (sourceOnes.get(0) instanceof CountryInfo 		&&
			sourceTwos.get(0) instanceof CountryLegalInfo		)
			return new CountryLegalMergerCountry().merge((List<CountryInfo>) sourceOnes, (List<CountryLegalInfo>) sourceTwos);
		
		
		return null;
	}
}
