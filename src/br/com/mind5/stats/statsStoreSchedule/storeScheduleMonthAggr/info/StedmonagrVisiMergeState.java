package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class StedmonagrVisiMergeState extends InfoMergerVisitorTemplate<StedmonagrInfo, StateInfo> {

	@Override public boolean shouldMerge(StedmonagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StedmonagrInfo> merge(StedmonagrInfo baseInfo, StateInfo selectedInfo) {
		List<StedmonagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
