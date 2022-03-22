package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CutefiloniveMergerVisiCalonth extends InfoMergerVisitorTemplate<CutefiloniveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(CutefiloniveInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CutefiloniveInfo> merge(CutefiloniveInfo baseInfo, CalonthInfo selectedInfo) {
		List<CutefiloniveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
