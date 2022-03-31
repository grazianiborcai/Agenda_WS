package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekMergerVisiStolis extends InfoMergerVisitorTemplate<SchedeekInfo, StolisInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, StolisInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.stolises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
