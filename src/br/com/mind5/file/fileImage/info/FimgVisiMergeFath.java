package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class FimgVisiMergeFath implements InfoMergerVisitorV3<FimgInfo, FathInfo> {
	
	@Override public List<FimgInfo> beforeMerge(List<FimgInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<FimgInfo> getUniquifier() {
		return null;
	}
}
