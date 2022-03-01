package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SoweduliveMergerVisiCalonth extends InfoMergerVisitorTemplate<SoweduliveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SoweduliveInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SoweduliveInfo> merge(SoweduliveInfo baseInfo, CalonthInfo selectedInfo) {
		List<SoweduliveInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
