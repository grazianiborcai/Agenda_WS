package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorygeVisiMergeToSelect extends InfoMergerVisitorTemplate<StusorygeInfo, StusorygeInfo> {

	@Override public boolean shouldMerge(StusorygeInfo baseInfo, StusorygeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorygeInfo> merge(StusorygeInfo baseInfo, StusorygeInfo selectedInfo) {
		List<StusorygeInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
