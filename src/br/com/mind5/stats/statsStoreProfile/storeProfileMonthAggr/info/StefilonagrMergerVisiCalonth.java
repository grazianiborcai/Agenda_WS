package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StefilonagrMergerVisiCalonth extends InfoMergerVisitorTemplate<StefilonagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StefilonagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StefilonagrInfo> merge(StefilonagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<StefilonagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
