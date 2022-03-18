package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StefiloniveMergerVisiCalonth extends InfoMergerVisitorTemplate<StefiloniveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StefiloniveInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StefiloniveInfo> merge(StefiloniveInfo baseInfo, CalonthInfo selectedInfo) {
		List<StefiloniveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
