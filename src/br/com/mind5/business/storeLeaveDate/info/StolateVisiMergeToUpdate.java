package br.com.mind5.business.storeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolateVisiMergeToUpdate extends InfoMergerVisitorTemplate<StolateInfo, StolateInfo> {
	
	@Override public List<StolateInfo> beforeMerge(List<StolateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolateInfo baseInfo, StolateInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolateInfo> merge(StolateInfo baseInfo, StolateInfo selectedInfo) {
		List<StolateInfo> results = new ArrayList<>();
		
		baseInfo.yearValidFrom = selectedInfo.yearValidFrom;
		baseInfo.monthValidFrom = selectedInfo.monthValidFrom;
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolateInfo> getUniquifier() {
		return null;
	}
}
