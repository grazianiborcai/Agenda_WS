package br.com.mind5.business.orderItemSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemrapMergerVisiEmplres extends InfoMergerVisitorTemplate<OrdemrapInfo, EmplresInfo> {

	@Override public boolean shouldMerge(OrdemrapInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<OrdemrapInfo> merge(OrdemrapInfo baseInfo, EmplresInfo selectedInfo) {
		List<OrdemrapInfo> results = new ArrayList<>();
		
		baseInfo.codEmployeeSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
