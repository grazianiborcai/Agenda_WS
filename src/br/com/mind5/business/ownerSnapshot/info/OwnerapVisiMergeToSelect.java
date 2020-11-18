package br.com.mind5.business.ownerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerapVisiMergeToSelect extends InfoMergerVisitorTemplate<OwnerapInfo, OwnerapInfo> {
	
	@Override public List<OwnerapInfo> beforeMerge(List<OwnerapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnerapInfo baseInfo, OwnerapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnerapInfo> merge(OwnerapInfo baseInfo, OwnerapInfo selectedInfo) {
		List<OwnerapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnerapInfo> getUniquifier() {
		return null;
	}
}
