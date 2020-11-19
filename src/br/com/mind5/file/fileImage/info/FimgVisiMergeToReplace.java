package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeToReplace extends InfoMergerVisitorTemplate<FimgInfo, FimgInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		
		results.add(baseInfo);
		return results;
	}
}
