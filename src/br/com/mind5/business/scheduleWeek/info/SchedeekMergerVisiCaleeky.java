package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekMergerVisiCaleeky extends InfoMergerVisitorTemplate<SchedeekInfo, CaleekyInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, CaleekyInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, CaleekyInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.weekYear = selectedInfo.weekYear;
		
		results.add(baseInfo);
		return results;
	}
}
