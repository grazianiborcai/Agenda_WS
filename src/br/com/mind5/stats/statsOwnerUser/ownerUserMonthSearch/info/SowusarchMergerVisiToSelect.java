package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowusarchMergerVisiToSelect extends InfoMergerVisitorTemplate<SowusarchInfo, SowusarchInfo> {

	@Override public boolean shouldMerge(SowusarchInfo baseInfo, SowusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowusarchInfo> merge(SowusarchInfo baseInfo, SowusarchInfo selectedInfo) {
		List<SowusarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
