package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StordagrMergerVisiCalate extends InfoMergerVisitorTemplate<StordagrInfo, CalateInfo> {

	@Override public boolean shouldMerge(StordagrInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.date.isEqual(selectedInfo.date) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StordagrInfo> merge(StordagrInfo baseInfo, CalateInfo selectedInfo) {
		List<StordagrInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
