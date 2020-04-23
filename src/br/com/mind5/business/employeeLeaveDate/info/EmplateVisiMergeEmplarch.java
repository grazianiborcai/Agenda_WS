package br.com.mind5.business.employeeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmplateVisiMergeEmplarch implements InfoMergerVisitorV3<EmplateInfo, EmplarchInfo> {
	
	@Override public List<EmplateInfo> beforeMerge(List<EmplateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmplateInfo baseInfo, EmplarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplateInfo> merge(EmplateInfo baseInfo, EmplarchInfo selectedInfo) {
		List<EmplateInfo> results = new ArrayList<>();
		
		EmplateInfo result = EmplateInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmplateInfo> getUniquifier() {
		return null;
	}
}
