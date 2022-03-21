package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamoniveMergerVisiToSelect extends InfoMergerVisitorTemplate<CustamoniveInfo, CustamoniveInfo> {

	@Override public boolean shouldMerge(CustamoniveInfo baseInfo, CustamoniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CustamoniveInfo> merge(CustamoniveInfo baseInfo, CustamoniveInfo selectedInfo) {
		List<CustamoniveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
