package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedeekVisiMergeMonth implements InfoMergerVisitorV3<SchedeekInfo, MonthInfo> {
	
	@Override public List<SchedeekInfo> beforeMerge(List<SchedeekInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedeekInfo baseInfo, MonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, MonthInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.monthes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedeekInfo> getUniquifier() {
		return null;
	}
}
