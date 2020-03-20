package br.com.mind5.business.employeeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmparchVisiMergeToSelect implements InfoMergerVisitorV3<EmparchInfo, EmparchInfo> {
	
	@Override public List<EmparchInfo> beforeMerge(List<EmparchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmparchInfo> getUniquifier() {
		return null;
	}
}
