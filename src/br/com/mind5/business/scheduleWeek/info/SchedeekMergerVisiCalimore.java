package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekMergerVisiCalimore extends InfoMergerVisitorTemplate<SchedeekInfo, CalimoreInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, CalimoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, CalimoreInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.calimores.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
