package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowotiveMergerVisiCalonth extends InfoMergerVisitorTemplate<SowotiveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowotiveInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SowotiveInfo> merge(SowotiveInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowotiveInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
