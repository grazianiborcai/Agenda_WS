package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StuntmMergerVisiStuntmarch extends InfoMergerVisitorTemplate<StuntmInfo, StuntmarchInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, StuntmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, StuntmarchInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		StuntmInfo result = StuntmInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
