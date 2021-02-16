package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedayVisiMergeEmplres extends InfoMergerVisitorTemplate<SchedayInfo, EmplresInfo> {

	@Override public boolean shouldMerge(SchedayInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, EmplresInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.emplreses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
