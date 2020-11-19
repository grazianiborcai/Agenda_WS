package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeFath extends InfoMergerVisitorTemplate<FimgInfo, FathInfo> {
	@Override public boolean shouldMerge(FimgInfo baseInfo, FathInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FathInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.fileImgPath = selectedInfo.filePath;
		baseInfo.fileImgPathExternal = selectedInfo.filePathExternal;
		
		results.add(baseInfo);
		return results;
	}
}
