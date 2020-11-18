package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmplisVisiMergeFimist extends InfoMergerVisitorTemplate<EmplisInfo, FimistInfo> {
	
	@Override public List<EmplisInfo> beforeMerge(List<EmplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmplisInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&&
				baseInfo.codEmployee == selectedInfo.codEmployee		);
	}
	
	
	
	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, FimistInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		baseInfo.fimistData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmplisInfo> getUniquifier() {
		return null;
	}
}
