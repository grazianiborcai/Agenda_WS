package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmposVisiMergeEmplis extends InfoMergerVisitorTemplate<EmposInfo, EmplisInfo> {

	@Override public boolean shouldMerge(EmposInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner	&&
				baseInfo.codEmployee == selectedInfo.codEmployee  );
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, EmplisInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		baseInfo.emplisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
