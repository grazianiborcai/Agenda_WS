package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamoniveMergerVisiCalonth extends InfoMergerVisitorTemplate<CustamoniveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(CustamoniveInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CustamoniveInfo> merge(CustamoniveInfo baseInfo, CalonthInfo selectedInfo) {
		List<CustamoniveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
