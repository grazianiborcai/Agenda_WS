package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowotiveMergerVisiState extends InfoMergerVisitorTemplate<SowotiveInfo, StateInfo> {

	@Override public boolean shouldMerge(SowotiveInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowotiveInfo> merge(SowotiveInfo baseInfo, StateInfo selectedInfo) {
		List<SowotiveInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
