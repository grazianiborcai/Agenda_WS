package br.com.mind5.file.sysFileImageSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgysapMergerVisiToSelect extends InfoMergerVisitorTemplate<FimgysapInfo, FimgysapInfo> {
	
	@Override public boolean shouldMerge(FimgysapInfo baseInfo, FimgysapInfo selectedInfo) {
		return (baseInfo.codSnapshot == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<FimgysapInfo> merge(FimgysapInfo baseInfo, FimgysapInfo selectedInfo) {
		List<FimgysapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
