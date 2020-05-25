package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class SchedayVisiMergeWeekday implements InfoMergerVisitorV3<SchedayInfo, WeekdayInfo> {
	
	@Override public List<SchedayInfo> beforeMerge(List<SchedayInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedayInfo baseInfo, WeekdayInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, WeekdayInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.weekdays.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedayInfo> getUniquifier() {
		return null;
	}
}
