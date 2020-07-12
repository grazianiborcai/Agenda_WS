package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmplisVisiMergePerarch implements InfoMergerVisitorV3<EmplisInfo, PerarchInfo> {
	
	@Override public List<EmplisInfo> beforeMerge(List<EmplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmplisInfo baseInfo, PerarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, PerarchInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmplisInfo> getUniquifier() {
		return null;
	}
}