package br.com.mind5.business.employeeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplutmMergerVisiEmplutmarch extends InfoMergerVisitorTemplate<EmplutmInfo, EmplutmarchInfo> {
	
	@Override public boolean shouldMerge(EmplutmInfo baseInfo, EmplutmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmplutmInfo> merge(EmplutmInfo baseInfo, EmplutmarchInfo selectedInfo) {
		List<EmplutmInfo> results = new ArrayList<>();
		
		EmplutmInfo result = EmplutmInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
