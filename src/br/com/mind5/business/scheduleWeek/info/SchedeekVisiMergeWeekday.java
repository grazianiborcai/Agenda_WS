package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class SchedeekVisiMergeWeekday implements InfoMergerVisitorV3<SchedeekInfo, WeekdayInfo> {
	
	@Override public List<SchedeekInfo> beforeMerge(List<SchedeekInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedeekInfo baseInfo, WeekdayInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, WeekdayInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.weekdays.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedeekInfo> getUniquifier() {
		return null;
	}
}