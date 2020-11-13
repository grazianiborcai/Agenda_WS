package br.com.mind5.business.storeProspect.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoprosVisiMergeStoprarch implements InfoMergerVisitor<StoprosInfo, StoprarchInfo> {
	
	@Override public List<StoprosInfo> beforeMerge(List<StoprosInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoprosInfo baseInfo, StoprarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoprosInfo> merge(StoprosInfo baseInfo, StoprarchInfo selectedInfo) {
		List<StoprosInfo> results = new ArrayList<>();
		
		StoprosInfo result = StoprosInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoprosInfo> getUniquifier() {
		return null;
	}
}
