package br.com.mind5.business.employeeWorkTimeOutlier.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwoutVisiMergeToSelect extends InfoMergerVisitorTemplate<EmpwoutInfo, EmpwoutInfo> {

	@Override public boolean shouldMerge(EmpwoutInfo baseInfo, EmpwoutInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwoutInfo> merge(EmpwoutInfo baseInfo, EmpwoutInfo selectedInfo) {
		List<EmpwoutInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
