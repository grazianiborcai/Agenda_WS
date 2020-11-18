package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class FimgVisiMergeToUpdate extends InfoMergerVisitorTemplate<FimgInfo, FimgInfo> {
	
	@Override public List<FimgInfo> beforeMerge(List<FimgInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		selectedInfo.isCover = baseInfo.isCover;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FimgInfo> getUniquifier() {
		return null;
	}
}
