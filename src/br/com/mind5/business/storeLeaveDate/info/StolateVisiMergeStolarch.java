package br.com.mind5.business.storeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StolateVisiMergeStolarch extends InfoMergerVisitorTemplate<StolateInfo, StolarchInfo> {

	@Override public boolean shouldMerge(StolateInfo baseInfo, StolarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolateInfo> merge(StolateInfo baseInfo, StolarchInfo selectedInfo) {
		List<StolateInfo> results = new ArrayList<>();
		
		StolateInfo result = StolateInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
