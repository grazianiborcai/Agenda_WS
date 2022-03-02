package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;

final class SowashMergerVisiSoword extends InfoMergerVisitorTemplate<SowashInfo, SowordInfo> {

	@Override public boolean shouldMerge(SowashInfo baseInfo, SowordInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowashInfo> merge(SowashInfo baseInfo, SowordInfo selectedInfo) {
		List<SowashInfo> results = new ArrayList<>();
		
		baseInfo.sowordes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
