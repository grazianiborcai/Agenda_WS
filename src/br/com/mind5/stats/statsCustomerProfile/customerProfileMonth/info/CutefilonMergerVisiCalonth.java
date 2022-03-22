package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CutefilonMergerVisiCalonth extends InfoMergerVisitorTemplate<CutefilonInfo, CalonthInfo> {

	@Override public boolean shouldMerge(CutefilonInfo baseInfo, CalonthInfo selectedInfo) {
		return (baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<CutefilonInfo> merge(CutefilonInfo baseInfo, CalonthInfo selectedInfo) {
		List<CutefilonInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.month = selectedInfo.month;
		baseInfo.year = selectedInfo.year;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
