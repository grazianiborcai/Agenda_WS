package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeFimgnap extends InfoMergerVisitorTemplate<FimgInfo, FimgnapInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, FimgnapInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner	&&
				baseInfo.codFileImg == selectedInfo.codFileImg		);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FimgnapInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
