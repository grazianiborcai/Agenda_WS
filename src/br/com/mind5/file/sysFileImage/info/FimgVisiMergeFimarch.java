package br.com.mind5.file.sysFileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeFimarch extends InfoMergerVisitorTemplate<FimgysInfo, FimarchInfo> {
	
	@Override public boolean shouldMerge(FimgysInfo baseInfo, FimarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimgysInfo> merge(FimgysInfo baseInfo, FimarchInfo selectedInfo) {
		List<FimgysInfo> results = new ArrayList<>();
		
		baseInfo.codFileImg = selectedInfo.codFileImg;
		
		results.add(baseInfo);
		return results;
	}
}
