package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowotagrMergerVisiCalonth extends InfoMergerVisitorTemplate<SowotagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowotagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowotagrInfo> merge(SowotagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowotagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
