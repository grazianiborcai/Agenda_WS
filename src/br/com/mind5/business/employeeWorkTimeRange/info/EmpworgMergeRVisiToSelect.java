package br.com.mind5.business.employeeWorkTimeRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpworgMergeRVisiToSelect extends InfoMergerVisitorTemplate<EmpworgInfo, EmpworgInfo> {

	@Override public boolean shouldMerge(EmpworgInfo baseInfo, EmpworgInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpworgInfo> merge(EmpworgInfo baseInfo, EmpworgInfo selectedInfo) {
		List<EmpworgInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
