package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedayVisiMergeCalate extends InfoMergerVisitorTemplate<SchedayInfo, CalateInfo> {

	@Override public boolean shouldMerge(SchedayInfo baseInfo, CalateInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.date);
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, CalateInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.calates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
