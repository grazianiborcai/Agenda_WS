package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedmonVisiMergeSchedonthat implements InfoMergerVisitor<SchedmonInfo, SchedonthatInfo> {
	
	@Override public List<SchedmonInfo> beforeMerge(List<SchedmonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedmonInfo baseInfo, SchedonthatInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore && 
				baseInfo.year     == selectedInfo.year	   &&
				baseInfo.month    == selectedInfo.month			);
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, SchedonthatInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.schedonthates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedmonInfo> getUniquifier() {
		return null;
	}
}
