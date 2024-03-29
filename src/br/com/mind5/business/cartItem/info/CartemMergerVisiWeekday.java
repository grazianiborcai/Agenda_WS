package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class CartemMergerVisiWeekday extends InfoMergerVisitorTemplate<CartemInfo, WeekdayInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, WeekdayInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
