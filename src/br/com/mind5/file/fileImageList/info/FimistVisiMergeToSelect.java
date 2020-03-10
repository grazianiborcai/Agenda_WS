package br.com.mind5.file.fileImageList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class FimistVisiMergeToSelect implements InfoMergerVisitorV3<FimistInfo, FimistInfo> {
	
	@Override public List<FimistInfo> beforeMerge(List<FimistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<FimistInfo> getUniquifier() {
		return null;
	}
}
