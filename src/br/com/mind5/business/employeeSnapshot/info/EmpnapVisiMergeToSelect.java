package br.com.mind5.business.employeeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapVisiMergeToSelect extends InfoMergerVisitorTemplate<EmpnapInfo, EmpnapInfo> {
	
	@Override public List<EmpnapInfo> beforeMerge(List<EmpnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpnapInfo baseInfo, EmpnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpnapInfo> merge(EmpnapInfo baseInfo, EmpnapInfo selectedInfo) {
		List<EmpnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpnapInfo> getUniquifier() {
		return new EmpnapUniquifier();
	}
}
