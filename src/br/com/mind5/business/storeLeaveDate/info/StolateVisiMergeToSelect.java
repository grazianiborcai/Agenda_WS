package br.com.mind5.business.storeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolateVisiMergeToSelect extends InfoMergerVisitorTemplate<StolateInfo, StolateInfo> {
	
	@Override public List<StolateInfo> beforeMerge(List<StolateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolateInfo baseInfo, StolateInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
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
