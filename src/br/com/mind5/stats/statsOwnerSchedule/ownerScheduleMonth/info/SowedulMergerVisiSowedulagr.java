package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

final class SowedulMergerVisiSowedulagr extends InfoMergerVisitorTemplate<SowedulInfo, SowedulagrInfo> {

	@Override public boolean shouldMerge(SowedulInfo baseInfo, SowedulagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner 			&&
				baseInfo.calmonth.equals(selectedInfo.calmonth) 	&&
				baseInfo.codCountry.equals(selectedInfo.codCountry) &&
				baseInfo.codState.equals(selectedInfo.codState) 	&&
				baseInfo.city.equals(selectedInfo.city) 				);
	}
	
	
	
	@Override public List<SowedulInfo> merge(SowedulInfo baseInfo, SowedulagrInfo selectedInfo) {
		List<SowedulInfo> results = new ArrayList<>();
		
		SowedulInfo result = SowedulInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
