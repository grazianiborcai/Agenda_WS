package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorashMergerVisiCalonth extends InfoMergerVisitorTemplate<StorashInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StorashInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StorashInfo> merge(StorashInfo baseInfo, CalonthInfo selectedInfo) {
		List<StorashInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		
		results.add(baseInfo);
		return results;
	}
}
