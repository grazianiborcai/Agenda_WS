package br.com.mind5.business.scheduleList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedistVisiMergeToSelect implements InfoMergerVisitorV3<SchedistInfo, SchedistInfo> {
	
	@Override public List<SchedistInfo> beforeMerge(List<SchedistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<SchedistInfo> getUniquifier() {
		return null;
	}
}
