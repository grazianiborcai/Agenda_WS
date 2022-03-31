package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedayMergerVisiCuslis extends InfoMergerVisitorTemplate<SchedayInfo, CuslisInfo> {

	@Override public boolean shouldMerge(SchedayInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, CuslisInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.cuslises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
