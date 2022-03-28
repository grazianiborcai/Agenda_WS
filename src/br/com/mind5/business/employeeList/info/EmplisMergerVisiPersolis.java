package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplisMergerVisiPersolis extends InfoMergerVisitorTemplate<EmplisInfo, PersolisInfo> {
	
	@Override public boolean shouldMerge(EmplisInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, PersolisInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		baseInfo.persolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
