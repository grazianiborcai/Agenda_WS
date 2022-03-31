package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedmonMergerVisiSchedonthat extends InfoMergerVisitorTemplate<SchedmonInfo, SchedonthatInfo> {

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
}
