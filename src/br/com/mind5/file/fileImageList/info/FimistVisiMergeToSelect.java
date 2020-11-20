package br.com.mind5.file.fileImageList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimistVisiMergeToSelect extends InfoMergerVisitorTemplate<FimistInfo, FimistInfo> {	
	
	@Override public boolean shouldMerge(FimistInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimistInfo> merge(FimistInfo baseInfo, FimistInfo selectedInfo) {
		List<FimistInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
