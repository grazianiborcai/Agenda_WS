package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamonagrMergerVisiCalonth extends InfoMergerVisitorTemplate<CustamonagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(CustamonagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CustamonagrInfo> merge(CustamonagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<CustamonagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
