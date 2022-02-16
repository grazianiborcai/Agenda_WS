package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SteddagrVisiMergeState extends InfoMergerVisitorTemplate<SteddagrInfo, StateInfo> {

	@Override public boolean shouldMerge(SteddagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SteddagrInfo> merge(SteddagrInfo baseInfo, StateInfo selectedInfo) {
		List<SteddagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
