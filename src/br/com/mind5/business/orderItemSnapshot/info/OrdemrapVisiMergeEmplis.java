package br.com.mind5.business.orderItemSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapVisiMergeEmplis extends InfoMergerVisitorTemplate<OrdemrapInfo, EmplisInfo> {
	
	@Override public List<OrdemrapInfo> beforeMerge(List<OrdemrapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdemrapInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<OrdemrapInfo> merge(OrdemrapInfo baseInfo, EmplisInfo selectedInfo) {
		List<OrdemrapInfo> results = new ArrayList<>();
		
		baseInfo.codEmployeeSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdemrapInfo> getUniquifier() {
		return null;
	}
}
