package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmposMergerVisiEmposarch extends InfoMergerVisitorTemplate<EmposInfo, EmposarchInfo> {

	@Override public boolean shouldMerge(EmposInfo baseInfo, EmposarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, EmposarchInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		EmposInfo result = EmposInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
