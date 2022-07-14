package br.com.mind5.stats.statsStoreOrder.storeOrderDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StordMergerVisiCalate extends InfoMergerVisitorTemplate<StordInfo, CalateInfo> {

	@Override public boolean shouldMerge(StordInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.year  == selectedInfo.year	&&
				baseInfo.month == selectedInfo.month);
	}
	
	
	
	@Override public List<StordInfo> merge(StordInfo baseInfo, CalateInfo selectedInfo) {
		List<StordInfo> results = new ArrayList<>();
		
		baseInfo.day = selectedInfo.day;
		baseInfo.date = selectedInfo.date;
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
