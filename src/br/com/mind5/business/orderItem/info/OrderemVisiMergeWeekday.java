package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class OrderemVisiMergeWeekday implements InfoMergerVisitorV3<OrderemInfo, WeekdayInfo> {
	
	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderemInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, WeekdayInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
