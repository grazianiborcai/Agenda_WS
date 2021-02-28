package br.com.mind5.stats.userOrderYearAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorygrVisiMergeToSelect extends InfoMergerVisitorTemplate<StusorygrInfo, StusorygrInfo> {

	@Override public boolean shouldMerge(StusorygrInfo baseInfo, StusorygrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorygrInfo> merge(StusorygrInfo baseInfo, StusorygrInfo selectedInfo) {
		List<StusorygrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
