package br.com.mind5.file.sysFileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeFimgnap extends InfoMergerVisitorTemplate<FimgysInfo, FimgnapInfo> {
	
	@Override public boolean shouldMerge(FimgysInfo baseInfo, FimgnapInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner	&&
				baseInfo.codFileImg == selectedInfo.codFileImg		);
	}
	
	
	
	@Override public List<FimgysInfo> merge(FimgysInfo baseInfo, FimgnapInfo selectedInfo) {
		List<FimgysInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
