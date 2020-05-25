package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedayVisiMergeMonth implements InfoMergerVisitorV3<SchedayInfo, MonthInfo> {
	
	@Override public List<SchedayInfo> beforeMerge(List<SchedayInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedayInfo baseInfo, MonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, MonthInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.monthes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedayInfo> getUniquifier() {
		return null;
	}
}
