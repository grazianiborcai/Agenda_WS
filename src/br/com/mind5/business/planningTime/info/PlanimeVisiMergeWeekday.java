package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class PlanimeVisiMergeWeekday implements InfoMergerVisitorV3<PlanimeInfo, WeekdayInfo> {
	
	@Override public List<PlanimeInfo> beforeMerge(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.weekdays = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanimeInfo baseInfo, WeekdayInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<PlanimeInfo> merge(PlanimeInfo baseInfo, WeekdayInfo selectedInfo) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		baseInfo.weekdays.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PlanimeInfo> getUniquifier() {
		return new PlanimeUniquifier();
	}
}
