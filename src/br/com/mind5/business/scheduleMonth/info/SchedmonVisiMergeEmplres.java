package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedmonVisiMergeEmplres extends InfoMergerVisitorTemplate<SchedmonInfo, EmplresInfo> {

	@Override public boolean shouldMerge(SchedmonInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, EmplresInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.emplreses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
