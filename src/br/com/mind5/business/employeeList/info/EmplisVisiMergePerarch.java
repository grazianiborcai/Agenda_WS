package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplisVisiMergePerarch extends InfoMergerVisitorTemplate<EmplisInfo, PerarchInfo> {
	@Override public boolean shouldMerge(EmplisInfo baseInfo, PerarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, PerarchInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
}
