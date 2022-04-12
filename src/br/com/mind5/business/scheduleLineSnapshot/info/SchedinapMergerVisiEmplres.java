package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedinapMergerVisiEmplres extends InfoMergerVisitorTemplate<SchedinapInfo, EmplresInfo> {

	@Override public boolean shouldMerge(SchedinapInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, EmplresInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		baseInfo.codEmployeeSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
