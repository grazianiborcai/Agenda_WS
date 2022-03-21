package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class CustamoniveMergerVisiState extends InfoMergerVisitorTemplate<CustamoniveInfo, StateInfo> {

	@Override public boolean shouldMerge(CustamoniveInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CustamoniveInfo> merge(CustamoniveInfo baseInfo, StateInfo selectedInfo) {
		List<CustamoniveInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
