package br.com.mind5.file.fileImageSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FimarchVisiMergeToSelect implements InfoMergerVisitor<FimarchInfo, FimarchInfo> {
	
	@Override public List<FimarchInfo> beforeMerge(List<FimarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FimarchInfo baseInfo, FimarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimarchInfo> merge(FimarchInfo baseInfo, FimarchInfo selectedInfo) {
		List<FimarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FimarchInfo> getUniquifier() {
		return null;
	}
}
