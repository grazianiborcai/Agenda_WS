package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamonagrMergerVisiToSelect extends InfoMergerVisitorTemplate<CustamonagrInfo, CustamonagrInfo> {

	@Override public boolean shouldMerge(CustamonagrInfo baseInfo, CustamonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CustamonagrInfo> merge(CustamonagrInfo baseInfo, CustamonagrInfo selectedInfo) {
		List<CustamonagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
