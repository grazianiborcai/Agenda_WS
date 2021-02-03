package br.com.mind5.masterData.countryLegalSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CountrarchVisiMergeToSelect extends InfoMergerVisitorTemplate<CountrarchInfo, CountrarchInfo> {

	@Override public boolean shouldMerge(CountrarchInfo baseInfo, CountrarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CountrarchInfo> merge(CountrarchInfo baseInfo, CountrarchInfo selectedInfo) {
		List<CountrarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
