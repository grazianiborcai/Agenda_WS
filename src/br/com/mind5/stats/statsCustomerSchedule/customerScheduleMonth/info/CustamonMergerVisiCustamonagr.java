package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

final class CustamonMergerVisiCustamonagr extends InfoMergerVisitorTemplate<CustamonInfo, CustamonagrInfo> {

	@Override public boolean shouldMerge(CustamonInfo baseInfo, CustamonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<CustamonInfo> merge(CustamonInfo baseInfo, CustamonagrInfo selectedInfo) {
		List<CustamonInfo> results = new ArrayList<>();
		
		CustamonInfo result = CustamonInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
