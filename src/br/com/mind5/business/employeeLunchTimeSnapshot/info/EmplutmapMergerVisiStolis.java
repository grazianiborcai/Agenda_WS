package br.com.mind5.business.employeeLunchTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplutmapMergerVisiStolis extends InfoMergerVisitorTemplate<EmplutmapInfo, StolisInfo> {
	
	@Override public boolean shouldMerge(EmplutmapInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<EmplutmapInfo> merge(EmplutmapInfo baseInfo, StolisInfo selectedInfo) {
		List<EmplutmapInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
