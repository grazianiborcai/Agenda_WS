package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowotagrMergerVisiState extends InfoMergerVisitorTemplate<SowotagrInfo, StateInfo> {

	@Override public boolean shouldMerge(SowotagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowotagrInfo> merge(SowotagrInfo baseInfo, StateInfo selectedInfo) {
		List<SowotagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
