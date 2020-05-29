package br.com.mind5.business.scheduleYearData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedyeratVisiMergeToSelect implements InfoMergerVisitorV3<SchedyeratInfo, SchedyeratInfo> {
	
	@Override public List<SchedyeratInfo> beforeMerge(List<SchedyeratInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedyeratInfo baseInfo, SchedyeratInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedyeratInfo> merge(SchedyeratInfo baseInfo, SchedyeratInfo selectedInfo) {
		List<SchedyeratInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedyeratInfo> getUniquifier() {
		return null;
	}
}
