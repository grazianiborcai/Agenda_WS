package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class OrderemMergerVisiWeekday extends InfoMergerVisitorTemplate<OrderemInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, WeekdayInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
