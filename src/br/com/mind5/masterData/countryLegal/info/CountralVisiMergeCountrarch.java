package br.com.mind5.masterData.countryLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;

final class CountralVisiMergeCountrarch extends InfoMergerVisitorTemplate<CountralInfo, CountrarchInfo> {
	
	@Override public List<CountralInfo> beforeMerge(List<CountralInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CountralInfo baseInfo, CountrarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CountralInfo> merge(CountralInfo baseInfo, CountrarchInfo selectedInfo) {
		List<CountralInfo> results = new ArrayList<>();
		CountralInfo result; 
		
		result = CountralInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CountralInfo> getUniquifier() {
		return null;
	}
}
