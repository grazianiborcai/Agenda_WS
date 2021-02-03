package br.com.mind5.masterData.state.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.country.info.CountryInfo;

final class StateVisiMergeCountry extends InfoMergerVisitorTemplate<StateInfo, CountryInfo> {

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
}
