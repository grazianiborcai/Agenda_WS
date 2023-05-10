package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowusagrMergerVisiToSelect extends InfoMergerVisitorTemplate<SowusagrInfo, SowusagrInfo> {

	@Override public boolean shouldMerge(SowusagrInfo baseInfo, SowusagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowusagrInfo> merge(SowusagrInfo baseInfo, SowusagrInfo selectedInfo) {
		List<SowusagrInfo> results = new ArrayList<>();
		
		selectedInfo.username    = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
