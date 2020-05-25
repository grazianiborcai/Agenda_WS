package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedayVisiMergeSchedonthat implements InfoMergerVisitorV3<SchedayInfo, SchedonthatInfo> {
	
	@Override public List<SchedayInfo> beforeMerge(List<SchedayInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedayInfo baseInfo, SchedonthatInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.year     == selectedInfo.year	   &&
				baseInfo.month    == selectedInfo.month			);
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, SchedonthatInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.schedonthats.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedayInfo> getUniquifier() {
		return null;
	}
}
