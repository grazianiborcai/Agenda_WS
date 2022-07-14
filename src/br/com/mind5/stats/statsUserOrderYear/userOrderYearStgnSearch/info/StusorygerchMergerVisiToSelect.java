package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorygerchMergerVisiToSelect extends InfoMergerVisitorTemplate<StusorygerchInfo, StusorygerchInfo> {

	@Override public boolean shouldMerge(StusorygerchInfo baseInfo, StusorygerchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorygerchInfo> merge(StusorygerchInfo baseInfo, StusorygerchInfo selectedInfo) {
		List<StusorygerchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
