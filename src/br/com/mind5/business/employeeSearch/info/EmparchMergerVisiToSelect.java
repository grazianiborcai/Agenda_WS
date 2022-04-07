package br.com.mind5.business.employeeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmparchMergerVisiToSelect extends InfoMergerVisitorTemplate<EmparchInfo, EmparchInfo> {
	
	@Override public boolean shouldMerge(EmparchInfo baseInfo, EmparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmparchInfo> merge(EmparchInfo baseInfo, EmparchInfo selectedInfo) {
		List<EmparchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
