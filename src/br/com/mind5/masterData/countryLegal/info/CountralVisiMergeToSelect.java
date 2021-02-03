package br.com.mind5.masterData.countryLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CountralVisiMergeToSelect extends InfoMergerVisitorTemplate<CountralInfo, CountralInfo> {

	@Override public boolean shouldMerge(CountralInfo baseInfo, CountralInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CountralInfo> merge(CountralInfo baseInfo, CountralInfo selectedInfo) {
		List<CountralInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
