package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowordMergerVisiCalonth extends InfoMergerVisitorTemplate<SowordInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowordInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SowordInfo> merge(SowordInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowordInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
