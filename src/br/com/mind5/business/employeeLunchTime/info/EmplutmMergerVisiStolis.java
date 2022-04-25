package br.com.mind5.business.employeeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplutmMergerVisiStolis extends InfoMergerVisitorTemplate<EmplutmInfo, StolisInfo> {
	
	@Override public boolean shouldMerge(EmplutmInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<EmplutmInfo> merge(EmplutmInfo baseInfo, StolisInfo selectedInfo) {
		List<EmplutmInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
