package br.com.mind5.business.storeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StolateVisiMergeToDelete implements InfoMergerVisitorV3<StolateInfo, StolateInfo> {
	
	@Override public List<StolateInfo> beforeMerge(List<StolateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolateInfo baseInfo, StolateInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&& 
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StolateInfo> merge(StolateInfo baseInfo, StolateInfo selectedInfo) {
		List<StolateInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolateInfo> getUniquifier() {
		return null;
	}
}
