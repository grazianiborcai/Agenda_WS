package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowedulagrVisiMergeState extends InfoMergerVisitorTemplate<SowedulagrInfo, StateInfo> {

	@Override public boolean shouldMerge(SowedulagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowedulagrInfo> merge(SowedulagrInfo baseInfo, StateInfo selectedInfo) {
		List<SowedulagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
