package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class CustamonagrMergerVisiState extends InfoMergerVisitorTemplate<CustamonagrInfo, StateInfo> {

	@Override public boolean shouldMerge(CustamonagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CustamonagrInfo> merge(CustamonagrInfo baseInfo, StateInfo selectedInfo) {
		List<CustamonagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
