package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedmonVisiMergeCalate extends InfoMergerVisitorTemplate<SchedmonInfo, CalateInfo> {

	@Override public boolean shouldMerge(SchedmonInfo baseInfo, CalateInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, CalateInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.calates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
