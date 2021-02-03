package br.com.mind5.business.scheduleSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedarchVisiMergeToSelect extends InfoMergerVisitorTemplate<SchedarchInfo, SchedarchInfo> {

	@Override public boolean shouldMerge(SchedarchInfo baseInfo, SchedarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedarchInfo> merge(SchedarchInfo baseInfo, SchedarchInfo selectedInfo) {
		List<SchedarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
