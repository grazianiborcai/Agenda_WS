package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CutefilonagrMergerVisiCalonth extends InfoMergerVisitorTemplate<CutefilonagrInfo, CalonthInfo> {

	@Override public boolean shouldMerge(CutefilonagrInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.calmonth.equals(selectedInfo.calmonth) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CutefilonagrInfo> merge(CutefilonagrInfo baseInfo, CalonthInfo selectedInfo) {
		List<CutefilonagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
