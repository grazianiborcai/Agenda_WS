package br.com.mind5.masterData.state.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StateVisiMergeCountry implements InfoMergerVisitorV3<StateInfo, CountryInfo> {
	
	@Override public List<StateInfo> beforeMerge(List<StateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StateInfo baseInfo, CountryInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<StateInfo> merge(StateInfo baseInfo, CountryInfo selectedInfo) {
		List<StateInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry 	  = selectedInfo.txtCountry;
		baseInfo.codCountryAlpha3 = selectedInfo.codCountryAlpha3;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StateInfo> getUniquifier() {
		return null;
	}
}