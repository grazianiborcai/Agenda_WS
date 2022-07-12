package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgMergerVisiFread extends InfoMergerVisitorTemplate<FimgInfo, FreadInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, FreadInfo selectedInfo) {
		return baseInfo.fileImgUri.equals(selectedInfo.fileUri);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FreadInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.fileImgData = selectedInfo.fileData;
		
		results.add(baseInfo);
		return results;
	}
}
