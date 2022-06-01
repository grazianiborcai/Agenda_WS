package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowashMergerVisiCalonth extends InfoMergerVisitorTemplate<SowashInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowashInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowashInfo> merge(SowashInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowashInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		
		results.add(baseInfo);
		return results;
	}
}
