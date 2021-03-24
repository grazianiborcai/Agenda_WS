package br.com.mind5.file.sysFileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgysVisiMergeFath extends InfoMergerVisitorTemplate<FimgysInfo, FathInfo> {
	
	@Override public boolean shouldMerge(FimgysInfo baseInfo, FathInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FimgysInfo> merge(FimgysInfo baseInfo, FathInfo selectedInfo) {
		List<FimgysInfo> results = new ArrayList<>();
		
		baseInfo.fileImgPath = selectedInfo.filePath;
		baseInfo.fileImgPathExternal = selectedInfo.filePathExternal;
		
		results.add(baseInfo);
		return results;
	}
}
