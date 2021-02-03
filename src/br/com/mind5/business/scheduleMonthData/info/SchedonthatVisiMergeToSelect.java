package br.com.mind5.business.scheduleMonthData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedonthatVisiMergeToSelect extends InfoMergerVisitorTemplate<SchedonthatInfo, SchedonthatInfo> {

	@Override public boolean shouldMerge(SchedonthatInfo baseInfo, SchedonthatInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedonthatInfo> merge(SchedonthatInfo baseInfo, SchedonthatInfo selectedInfo) {
		List<SchedonthatInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
