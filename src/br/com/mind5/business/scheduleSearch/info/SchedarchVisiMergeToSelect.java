package br.com.mind5.business.scheduleSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedarchVisiMergeToSelect implements InfoMergerVisitor<SchedarchInfo, SchedarchInfo> {
	
	@Override public List<SchedarchInfo> beforeMerge(List<SchedarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<SchedarchInfo> getUniquifier() {
		return null;
	}
}
