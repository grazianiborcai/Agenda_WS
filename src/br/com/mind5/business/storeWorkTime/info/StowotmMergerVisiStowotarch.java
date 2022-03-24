package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StowotmMergerVisiStowotarch extends InfoMergerVisitorTemplate<StowotmInfo, StowotarchInfo> {

	@Override public boolean shouldMerge(StowotmInfo baseInfo, StowotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, StowotarchInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		StowotmInfo result = StowotmInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
