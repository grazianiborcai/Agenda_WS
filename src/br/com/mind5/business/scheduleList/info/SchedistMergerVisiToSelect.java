package br.com.mind5.business.scheduleList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedistMergerVisiToSelect extends InfoMergerVisitorTemplate<SchedistInfo, SchedistInfo> {

	@Override public boolean shouldMerge(SchedistInfo baseInfo, SchedistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedistInfo> merge(SchedistInfo baseInfo, SchedistInfo selectedInfo) {
		List<SchedistInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
