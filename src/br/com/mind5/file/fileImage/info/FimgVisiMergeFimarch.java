package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeFimarch extends InfoMergerVisitorTemplate<FimgInfo, FimarchInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, FimarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FimarchInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.codFileImg = selectedInfo.codFileImg;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.MANY_TO_MANY;
	}
}
