package br.com.mind5.file.sysFileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgysVisiMergeFread extends InfoMergerVisitorTemplate<FimgysInfo, FreadInfo> {
	
	@Override public boolean shouldMerge(FimgysInfo baseInfo, FreadInfo selectedInfo) {
		return baseInfo.fileImgUri.equals(selectedInfo.fileUri);
	}
	
	
	
	@Override public List<FimgysInfo> merge(FimgysInfo baseInfo, FreadInfo selectedInfo) {
		List<FimgysInfo> results = new ArrayList<>();
		
		baseInfo.fileImgData = selectedInfo.fileData;
		
		results.add(baseInfo);
		return results;
	}
}
