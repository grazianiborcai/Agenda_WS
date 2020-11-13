package br.com.mind5.business.employeeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapVisiMergePhonap implements InfoMergerVisitor<EmpnapInfo, PhonapInfo> {
	
	@Override public List<EmpnapInfo> beforeMerge(List<EmpnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpnapInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 		&&
				baseInfo.codEmployee == selectedInfo.codEmployee	&&
				baseInfo.codSnapshot == selectedInfo.codEmployeeSnapshot	);
	}
	
	
	
	@Override public List<EmpnapInfo> merge(EmpnapInfo baseInfo, PhonapInfo selectedInfo) {
		List<EmpnapInfo> results = new ArrayList<>();
		
		baseInfo.phonaps.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpnapInfo> getUniquifier() {
		return new EmpnapUniquifier();
	}
}
