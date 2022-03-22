package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamonMergerVisiCalonth extends InfoMergerVisitorTemplate<CustamonInfo, CalonthInfo> {

	@Override public boolean shouldMerge(CustamonInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CustamonInfo> merge(CustamonInfo baseInfo, CalonthInfo selectedInfo) {
		List<CustamonInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.month = selectedInfo.month;
		baseInfo.year = selectedInfo.year;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
