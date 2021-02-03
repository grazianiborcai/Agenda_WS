package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedmonVisiMergeEmplis extends InfoMergerVisitorTemplate<SchedmonInfo, EmplisInfo> {

	@Override public boolean shouldMerge(SchedmonInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, EmplisInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.emplises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
