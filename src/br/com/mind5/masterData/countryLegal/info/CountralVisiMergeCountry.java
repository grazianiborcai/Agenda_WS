package br.com.mind5.masterData.countryLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.country.info.CountryInfo;

final class CountralVisiMergeCountry implements InfoMergerVisitor<CountralInfo, CountryInfo> {
	
	@Override public List<CountralInfo> beforeMerge(List<CountralInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CountralInfo> getUniquifier() {
		return null;
	}
}
