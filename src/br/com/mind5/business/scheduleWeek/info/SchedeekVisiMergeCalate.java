package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekVisiMergeCalate extends InfoMergerVisitorTemplate<SchedeekInfo, CalateInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, CalateInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, CalateInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.calates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
