package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StordiveMergerVisiCalate extends InfoMergerVisitorTemplate<StordiveInfo, CalateInfo> {

	@Override public boolean shouldMerge(StordiveInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.date.isEqual(selectedInfo.date) &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StordiveInfo> merge(StordiveInfo baseInfo, CalateInfo selectedInfo) {
		List<StordiveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
