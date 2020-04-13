package br.com.mind5.masterData.stateSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StatarchVisiMergeCountry implements InfoMergerVisitorV3<StatarchInfo, CountryInfo> {
	
	@Override public List<StatarchInfo> beforeMerge(List<StatarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StatarchInfo baseInfo, CountryInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<StatarchInfo> merge(StatarchInfo baseInfo, CountryInfo selectedInfo) {
		List<StatarchInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry 	  = selectedInfo.txtCountry;
		baseInfo.codCountryAlpha3 = selectedInfo.codCountryAlpha3;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StatarchInfo> getUniquifier() {
		return null;
	}
}
