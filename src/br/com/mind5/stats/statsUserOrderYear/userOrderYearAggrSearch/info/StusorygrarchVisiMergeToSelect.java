package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorygrarchVisiMergeToSelect extends InfoMergerVisitorTemplate<StusorygrarchInfo, StusorygrarchInfo> {

	@Override public boolean shouldMerge(StusorygrarchInfo baseInfo, StusorygrarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorygrarchInfo> merge(StusorygrarchInfo baseInfo, StusorygrarchInfo selectedInfo) {
		List<StusorygrarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
