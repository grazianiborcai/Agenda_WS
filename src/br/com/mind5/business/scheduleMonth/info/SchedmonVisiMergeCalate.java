package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedmonVisiMergeCalate implements InfoMergerVisitor<SchedmonInfo, CalateInfo> {
	
	@Override public List<SchedmonInfo> beforeMerge(List<SchedmonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedmonInfo baseInfo, CalateInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, CalateInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.calates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedmonInfo> getUniquifier() {
		return null;
	}
}
