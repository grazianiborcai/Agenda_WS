package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowusagrMergerVisiCalonth extends InfoMergerVisitorTemplate<SowusagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowusagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowusagrInfo> merge(SowusagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowusagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
