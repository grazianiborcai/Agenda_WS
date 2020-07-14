package br.com.mind5.business.employeeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapVisiMergePersonap implements InfoMergerVisitorV3<EmpnapInfo, PersonapInfo> {
	
	@Override public List<EmpnapInfo> beforeMerge(List<EmpnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpnapInfo baseInfo, PersonapInfo selectedInfo) {
		return (baseInfo.codOwner    	   == selectedInfo.codOwner		&&
				baseInfo.codPerson   	   == selectedInfo.codPerson	&&
				baseInfo.codPersonSnapshot == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<EmpnapInfo> merge(EmpnapInfo baseInfo, PersonapInfo selectedInfo) {
		List<EmpnapInfo> results = new ArrayList<>();
		
		baseInfo.personapData = PersonapInfo.copyFrom(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpnapInfo> getUniquifier() {
		return new EmpnapUniquifier();
	}
}
