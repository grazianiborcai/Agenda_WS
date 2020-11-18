package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmVisiMergeToDelete extends InfoMergerVisitorTemplate<EmpwotmInfo, EmpwotmInfo> {
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, EmpwotmInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, EmpwotmInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
