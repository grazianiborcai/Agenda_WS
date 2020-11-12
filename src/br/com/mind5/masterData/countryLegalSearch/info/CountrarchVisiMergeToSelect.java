package br.com.mind5.masterData.countryLegalSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CountrarchVisiMergeToSelect implements InfoMergerVisitorV3<CountrarchInfo, CountrarchInfo> {
	
	@Override public List<CountrarchInfo> beforeMerge(List<CountrarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CountrarchInfo baseInfo, CountrarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CountrarchInfo> merge(CountrarchInfo baseInfo, CountrarchInfo selectedInfo) {
		List<CountrarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CountrarchInfo> getUniquifier() {
		return null;
	}
}
