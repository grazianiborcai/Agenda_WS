package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeToSelect extends InfoMergerVisitorTemplate<StolisInfo, StolisInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, StolisInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();		
		return uniquifier.uniquify(results);
	}
}
