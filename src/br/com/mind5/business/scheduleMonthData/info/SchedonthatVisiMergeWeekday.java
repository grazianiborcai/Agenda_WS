package br.com.mind5.business.scheduleMonthData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class SchedonthatVisiMergeWeekday implements InfoMergerVisitorV3<SchedonthatInfo, WeekdayInfo> {
	
	@Override public List<SchedonthatInfo> beforeMerge(List<SchedonthatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedonthatInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday && 
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SchedonthatInfo> merge(SchedonthatInfo baseInfo, WeekdayInfo selectedInfo) {
		List<SchedonthatInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedonthatInfo> getUniquifier() {
		return null;
	}
}
