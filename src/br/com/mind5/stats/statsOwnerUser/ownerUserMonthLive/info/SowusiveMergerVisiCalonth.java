package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowusiveMergerVisiCalonth extends InfoMergerVisitorTemplate<SowusiveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowusiveInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SowusiveInfo> merge(SowusiveInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowusiveInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
