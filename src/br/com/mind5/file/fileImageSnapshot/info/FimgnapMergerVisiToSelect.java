package br.com.mind5.file.fileImageSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgnapMergerVisiToSelect extends InfoMergerVisitorTemplate<FimgnapInfo, FimgnapInfo> {
	
	@Override public boolean shouldMerge(FimgnapInfo baseInfo, FimgnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimgnapInfo> merge(FimgnapInfo baseInfo, FimgnapInfo selectedInfo) {
		List<FimgnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
