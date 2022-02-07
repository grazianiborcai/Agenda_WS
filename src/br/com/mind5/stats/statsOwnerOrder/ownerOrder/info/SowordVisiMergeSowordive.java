package br.com.mind5.stats.statsOwnerOrder.ownerOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;

final class SowordVisiMergeSowordive extends InfoMergerVisitorTemplate<SowordInfo, SowordiveInfo> {

	@Override public boolean shouldMerge(SowordInfo baseInfo, SowordiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowordInfo> merge(SowordInfo baseInfo, SowordiveInfo selectedInfo) {
		List<SowordInfo> results = new ArrayList<>();
		
		SowordInfo result = SowordInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
