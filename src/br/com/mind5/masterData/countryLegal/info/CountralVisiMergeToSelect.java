package br.com.mind5.masterData.countryLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CountralVisiMergeToSelect implements InfoMergerVisitorV3<CountralInfo, CountralInfo> {
	
	@Override public List<CountralInfo> beforeMerge(List<CountralInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CountralInfo baseInfo, CountralInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CountralInfo> merge(CountralInfo baseInfo, CountralInfo selectedInfo) {
		List<CountralInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CountralInfo> getUniquifier() {
		return null;
	}
}
