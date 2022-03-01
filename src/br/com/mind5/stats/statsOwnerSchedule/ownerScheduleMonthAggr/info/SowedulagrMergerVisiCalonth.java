package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowedulagrMergerVisiCalonth extends InfoMergerVisitorTemplate<SowedulagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowedulagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowedulagrInfo> merge(SowedulagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowedulagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
