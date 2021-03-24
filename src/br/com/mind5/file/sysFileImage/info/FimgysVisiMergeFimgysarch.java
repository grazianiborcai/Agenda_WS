package br.com.mind5.file.sysFileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgysVisiMergeFimgysarch extends InfoMergerVisitorTemplate<FimgysInfo, FimgysarchInfo> {
	
	@Override public boolean shouldMerge(FimgysInfo baseInfo, FimgysarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FimgysInfo> merge(FimgysInfo baseInfo, FimgysarchInfo selectedInfo) {
		List<FimgysInfo> results = new ArrayList<>();
		
		baseInfo.codFileImg = selectedInfo.codFileImg;
		
		results.add(baseInfo);
		return results;
	}
}
