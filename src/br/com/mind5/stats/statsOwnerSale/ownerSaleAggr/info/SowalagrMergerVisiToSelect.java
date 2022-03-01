package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowalagrMergerVisiToSelect extends InfoMergerVisitorTemplate<SowalagrInfo, SowalagrInfo> {

	@Override public boolean shouldMerge(SowalagrInfo baseInfo, SowalagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowalagrInfo> merge(SowalagrInfo baseInfo, SowalagrInfo selectedInfo) {
		List<SowalagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
