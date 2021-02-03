package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedinapVisiMergeEmplis extends InfoMergerVisitorTemplate<SchedinapInfo, EmplisInfo> {

	@Override public boolean shouldMerge(SchedinapInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, EmplisInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		baseInfo.codEmployeeSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
