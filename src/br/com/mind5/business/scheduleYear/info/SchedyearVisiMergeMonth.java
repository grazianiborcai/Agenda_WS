package br.com.mind5.business.scheduleYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedyearVisiMergeMonth implements InfoMergerVisitorV3<SchedyearInfo, MonthInfo> {
	
	@Override public List<SchedyearInfo> beforeMerge(List<SchedyearInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedyearInfo baseInfo, MonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedyearInfo> merge(SchedyearInfo baseInfo, MonthInfo selectedInfo) {
		List<SchedyearInfo> results = new ArrayList<>();
		
		baseInfo.monthes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedyearInfo> getUniquifier() {
		return null;
	}
}
