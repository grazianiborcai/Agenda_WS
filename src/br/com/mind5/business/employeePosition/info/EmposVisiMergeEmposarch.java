package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmposVisiMergeEmposarch implements InfoMergerVisitorV3<EmposInfo, EmposarchInfo> {
	
	@Override public List<EmposInfo> beforeMerge(List<EmposInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmposInfo baseInfo, EmposarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, EmposarchInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		baseInfo.codOwner = selectedInfo.codOwner;	
		baseInfo.codStore = selectedInfo.codStore;	
		baseInfo.codEmployee = selectedInfo.codEmployee;
		baseInfo.codPosition = selectedInfo.codPosition;
		baseInfo.username = selectedInfo.username;
		baseInfo.codLanguage = selectedInfo.codLanguage;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmposInfo> getUniquifier() {
		return null;
	}
}
