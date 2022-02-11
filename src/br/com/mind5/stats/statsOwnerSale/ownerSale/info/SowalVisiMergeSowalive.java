package br.com.mind5.stats.statsOwnerSale.ownerSale.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

final class SowalVisiMergeSowalive extends InfoMergerVisitorTemplate<SowalInfo, SowaliveInfo> {

	@Override public boolean shouldMerge(SowalInfo baseInfo, SowaliveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowalInfo> merge(SowalInfo baseInfo, SowaliveInfo selectedInfo) {
		List<SowalInfo> results = new ArrayList<>();
		
		SowalInfo result = SowalInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
