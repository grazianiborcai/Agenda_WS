package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedayVisiMergeEmplis extends InfoMergerVisitorTemplate<SchedayInfo, EmplisInfo> {

	@Override public boolean shouldMerge(SchedayInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, EmplisInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.emplises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
