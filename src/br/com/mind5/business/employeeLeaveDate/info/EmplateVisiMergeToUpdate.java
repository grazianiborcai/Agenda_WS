package br.com.mind5.business.employeeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmplateVisiMergeToUpdate implements InfoMergerVisitorV3<EmplateInfo, EmplateInfo> {
	
	@Override public List<EmplateInfo> beforeMerge(List<EmplateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmplateInfo baseInfo, EmplateInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplateInfo> merge(EmplateInfo baseInfo, EmplateInfo selectedInfo) {
		List<EmplateInfo> results = new ArrayList<>();
		
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmplateInfo> getUniquifier() {
		return null;
	}
}
