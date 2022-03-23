package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedineMergerVisiStolis extends InfoMergerVisitorTemplate<SchedineInfo, StolisInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, StolisInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
