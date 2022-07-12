package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgMergerVisiToUpdate extends InfoMergerVisitorTemplate<FimgInfo, FimgInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		selectedInfo.fileImgExtension = baseInfo.fileImgExtension;
		selectedInfo.fileImgName = baseInfo.fileImgName;
		selectedInfo.fileImgUri = baseInfo.fileImgUri;
		selectedInfo.fileImgPath = baseInfo.fileImgPath;
		selectedInfo.fileImgPathExternal = baseInfo.fileImgPathExternal;
		selectedInfo.fileImgUriExternal = baseInfo.fileImgUriExternal;
		selectedInfo.isCover = baseInfo.isCover;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
