package br.com.mind5.business.employeeWorkTimeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotarchMergerVisiToSelect extends InfoMergerVisitorTemplate<EmpwotarchInfo, EmpwotarchInfo> {

	@Override public boolean shouldMerge(EmpwotarchInfo baseInfo, EmpwotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwotarchInfo> merge(EmpwotarchInfo baseInfo, EmpwotarchInfo selectedInfo) {
		List<EmpwotarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
