package br.com.mind5.business.employeeWorkTimeOutlier.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpwoutVisiMergeToSelect implements InfoMergerVisitorV3<EmpwoutInfo, EmpwoutInfo> {
	
	@Override public List<EmpwoutInfo> beforeMerge(List<EmpwoutInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmpwoutInfo> getUniquifier() {
		return null;
	}
}
