package br.com.mind5.business.storeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolateVisiMergeStolarch implements InfoMergerVisitor<StolateInfo, StolarchInfo> {
	
	@Override public List<StolateInfo> beforeMerge(List<StolateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolateInfo baseInfo, StolarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolateInfo> merge(StolateInfo baseInfo, StolarchInfo selectedInfo) {
		List<StolateInfo> results = new ArrayList<>();
		
		StolateInfo result = StolateInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolateInfo> getUniquifier() {
		return null;
	}
}
