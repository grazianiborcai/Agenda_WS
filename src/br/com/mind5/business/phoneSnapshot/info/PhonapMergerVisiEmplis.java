package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhonapMergerVisiEmplis extends InfoMergerVisitorTemplate<PhonapInfo, EmplisInfo> {

	@Override public boolean shouldMerge(PhonapInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	&&
				baseInfo.codEmployee == selectedInfo.codEmployee		);
	}
	
	
	
	@Override public List<PhonapInfo> merge(PhonapInfo baseInfo, EmplisInfo selectedInfo) {
		List<PhonapInfo> results = new ArrayList<>();
		
		baseInfo.codEmployeeSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
