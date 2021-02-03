package br.com.mind5.masterData.countryLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.country.info.CountryInfo;

final class CountralVisiMergeCountry extends InfoMergerVisitorTemplate<CountralInfo, CountryInfo> {

	@Override public boolean shouldMerge(CountralInfo baseInfo, CountryInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<CountralInfo> merge(CountralInfo baseInfo, CountryInfo selectedInfo) {
		List<CountralInfo> results = new ArrayList<>();
		CountralInfo result = new CountralInfo();
		
		result = CountralInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
