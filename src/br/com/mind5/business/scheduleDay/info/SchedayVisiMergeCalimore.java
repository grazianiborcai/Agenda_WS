package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedayVisiMergeCalimore extends InfoMergerVisitorTemplate<SchedayInfo, CalimoreInfo> {

	@Override public boolean shouldMerge(SchedayInfo baseInfo, CalimoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.date.isEqual(selectedInfo.date)		);
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, CalimoreInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.calimores.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
