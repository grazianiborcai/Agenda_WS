package br.com.mind5.file.sysFileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgysMergerVisiFimgysap extends InfoMergerVisitorTemplate<FimgysInfo, FimgysapInfo> {
	
	@Override public boolean shouldMerge(FimgysInfo baseInfo, FimgysapInfo selectedInfo) {
		return (baseInfo.codFileImg == selectedInfo.codFileImg		);
	}
	
	
	
	@Override public List<FimgysInfo> merge(FimgysInfo baseInfo, FimgysapInfo selectedInfo) {
		List<FimgysInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
