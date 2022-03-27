package br.com.mind5.business.employeeWorkTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmapMergerVisiToSelect extends InfoMergerVisitorTemplate<EmpwotmapInfo, EmpwotmapInfo> {
	
	@Override public boolean shouldMerge(EmpwotmapInfo baseInfo, EmpwotmapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwotmapInfo> merge(EmpwotmapInfo baseInfo, EmpwotmapInfo selectedInfo) {
		List<EmpwotmapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
