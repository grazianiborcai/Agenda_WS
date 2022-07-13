package br.com.mind5.file.sysFileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgysMergerVisiToSelect extends InfoMergerVisitorTemplate<FimgysInfo, FimgysInfo> {
	
	@Override public boolean shouldMerge(FimgysInfo baseInfo, FimgysInfo selectedInfo) {
		return (baseInfo.codFileImg == selectedInfo.codFileImg);
	}
	
	
	
	@Override public List<FimgysInfo> merge(FimgysInfo baseInfo, FimgysInfo selectedInfo) {
		List<FimgysInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
