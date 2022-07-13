package br.com.mind5.file.sysFileImageSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgysarchMergerVisiToSelect extends InfoMergerVisitorTemplate<FimgysarchInfo, FimgysarchInfo> {

	@Override public boolean shouldMerge(FimgysarchInfo baseInfo, FimgysarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FimgysarchInfo> merge(FimgysarchInfo baseInfo, FimgysarchInfo selectedInfo) {
		List<FimgysarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
