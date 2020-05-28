package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedmonVisiMergeMonth implements InfoMergerVisitorV3<SchedmonInfo, MonthInfo> {
	
	@Override public List<SchedmonInfo> beforeMerge(List<SchedmonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedmonInfo baseInfo, MonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, MonthInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.monthes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedmonInfo> getUniquifier() {
		return null;
	}
}
