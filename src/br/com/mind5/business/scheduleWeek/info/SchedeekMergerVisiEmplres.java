package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekMergerVisiEmplres extends InfoMergerVisitorTemplate<SchedeekInfo, EmplresInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, EmplresInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.emplreses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
