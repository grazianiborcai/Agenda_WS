package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedineMergerVisiEmplres extends InfoMergerVisitorTemplate<SchedineInfo, EmplresInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, EmplresInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.emplresData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
