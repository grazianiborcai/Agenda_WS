package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowotiveVisiMergeToSelect extends InfoMergerVisitorTemplate<SowotiveInfo, SowotiveInfo> {

	@Override public boolean shouldMerge(SowotiveInfo baseInfo, SowotiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowotiveInfo> merge(SowotiveInfo baseInfo, SowotiveInfo selectedInfo) {
		List<SowotiveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
