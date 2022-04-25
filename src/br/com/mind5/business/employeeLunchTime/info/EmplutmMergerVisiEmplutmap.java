package br.com.mind5.business.employeeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplutmMergerVisiEmplutmap extends InfoMergerVisitorTemplate<EmplutmInfo, EmplutmapInfo> {

	@Override public boolean shouldMerge(EmplutmInfo baseInfo, EmplutmapInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner    &&
				baseInfo.codStore    == selectedInfo.codStore    &&
				baseInfo.codEmployee == selectedInfo.codEmployee &&
				baseInfo.codWeekday  == selectedInfo.codWeekday);
	}
	
	

	@Override public List<EmplutmInfo> merge(EmplutmInfo baseInfo, EmplutmapInfo selectedInfo) {
		List<EmplutmInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
