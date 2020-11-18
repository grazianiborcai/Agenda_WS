package br.com.mind5.business.orderItemSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class OrdemrapVisiMergeWeekday extends InfoMergerVisitorTemplate<OrdemrapInfo, WeekdayInfo> {
	
	@Override public List<OrdemrapInfo> beforeMerge(List<OrdemrapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdemrapInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday);
	}
	
	
	
	@Override public List<OrdemrapInfo> merge(OrdemrapInfo baseInfo, WeekdayInfo selectedInfo) {
		List<OrdemrapInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdemrapInfo> getUniquifier() {
		return null;
	}
}
