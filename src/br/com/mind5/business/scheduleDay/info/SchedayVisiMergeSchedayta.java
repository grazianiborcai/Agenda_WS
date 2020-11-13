package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedayVisiMergeSchedayta implements InfoMergerVisitor<SchedayInfo, SchedaytaInfo> {
	
	@Override public List<SchedayInfo> beforeMerge(List<SchedayInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedayInfo baseInfo, SchedaytaInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore&&
				baseInfo.date.equals(selectedInfo.date));
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, SchedaytaInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.schedaytas.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedayInfo> getUniquifier() {
		return null;
	}
}
