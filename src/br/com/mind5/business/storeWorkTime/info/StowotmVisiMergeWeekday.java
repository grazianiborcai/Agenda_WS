package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class StowotmVisiMergeWeekday implements InfoMergerVisitorV3<StowotmInfo, WeekdayInfo> {
	
	@Override public List<StowotmInfo> beforeMerge(List<StowotmInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StowotmInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, WeekdayInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StowotmInfo> getUniquifier() {
		return null;
	}
}
