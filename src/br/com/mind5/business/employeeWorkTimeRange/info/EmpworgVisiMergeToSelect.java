package br.com.mind5.business.employeeWorkTimeRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpworgVisiMergeToSelect implements InfoMergerVisitor<EmpworgInfo, EmpworgInfo> {
	
	@Override public List<EmpworgInfo> beforeMerge(List<EmpworgInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmpworgInfo> getUniquifier() {
		return null;
	}
}
