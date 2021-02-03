package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekVisiMergeCalimemp extends InfoMergerVisitorTemplate<SchedeekInfo, CalimempInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, CalimempInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, CalimempInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.calimempes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
