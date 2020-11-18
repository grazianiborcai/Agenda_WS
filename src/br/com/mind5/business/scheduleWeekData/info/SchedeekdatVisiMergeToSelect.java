package br.com.mind5.business.scheduleWeekData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekdatVisiMergeToSelect extends InfoMergerVisitorTemplate<SchedeekdatInfo, SchedeekdatInfo> {
	
	@Override public List<SchedeekdatInfo> beforeMerge(List<SchedeekdatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedeekdatInfo baseInfo, SchedeekdatInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedeekdatInfo> merge(SchedeekdatInfo baseInfo, SchedeekdatInfo selectedInfo) {
		List<SchedeekdatInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedeekdatInfo> getUniquifier() {
		return null;
	}
}
