package br.com.mind5.stats.userStoreLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusoreveVisiMergeToSelect extends InfoMergerVisitorTemplate<StusoreveInfo, StusoreveInfo> {

	@Override public boolean shouldMerge(StusoreveInfo baseInfo, StusoreveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusoreveInfo> merge(StusoreveInfo baseInfo, StusoreveInfo selectedInfo) {
		List<StusoreveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
