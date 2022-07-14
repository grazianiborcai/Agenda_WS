package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorylirchMergerVisiToSelect extends InfoMergerVisitorTemplate<StusorylirchInfo, StusorylirchInfo> {

	@Override public boolean shouldMerge(StusorylirchInfo baseInfo, StusorylirchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorylirchInfo> merge(StusorylirchInfo baseInfo, StusorylirchInfo selectedInfo) {
		List<StusorylirchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
