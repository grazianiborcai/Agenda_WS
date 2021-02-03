package br.com.mind5.business.scheduleDayData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedaytaVisiMergeToSelect extends InfoMergerVisitorTemplate<SchedaytaInfo, SchedaytaInfo> {

	@Override public boolean shouldMerge(SchedaytaInfo baseInfo, SchedaytaInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedaytaInfo> merge(SchedaytaInfo baseInfo, SchedaytaInfo selectedInfo) {
		List<SchedaytaInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
