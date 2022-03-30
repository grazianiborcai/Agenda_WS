package br.com.mind5.business.employeeRestricted.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.personRestricted.info.PersoresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplresMergerVisiEmplis extends InfoMergerVisitorTemplate<EmplresInfo, EmplisInfo> {
	
	@Override public boolean shouldMerge(EmplresInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner	&&
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<EmplresInfo> merge(EmplresInfo baseInfo, EmplisInfo selectedInfo) {
		List<EmplresInfo> results = new ArrayList<>();
		
		EmplresInfo result = EmplresInfo.copyFrom(selectedInfo);
		result.persoresData = PersoresInfo.copyFrom(selectedInfo.persolisData);
		
		results.add(result);
		return results;
	}
}
