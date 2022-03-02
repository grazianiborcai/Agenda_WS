package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;

final class SowashMergerVisiSowal extends InfoMergerVisitorTemplate<SowashInfo, SowalInfo> {

	@Override public boolean shouldMerge(SowashInfo baseInfo, SowalInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowashInfo> merge(SowashInfo baseInfo, SowalInfo selectedInfo) {
		List<SowashInfo> results = new ArrayList<>();
		
		baseInfo.sowales.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
