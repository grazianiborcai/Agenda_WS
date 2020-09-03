package br.com.mind5.business.calendarCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class CalgueVisiMergeWeekday implements InfoMergerVisitorV3<CalgueInfo, WeekdayInfo> {
	
	@Override public List<CalgueInfo> beforeMerge(List<CalgueInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalgueInfo baseInfo, WeekdayInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalgueInfo> merge(CalgueInfo baseInfo, WeekdayInfo selectedInfo) {
		List<CalgueInfo> results = new ArrayList<>();
		
		baseInfo.weekdays.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
		
	@Override public InfoUniquifier<CalgueInfo> getUniquifier() {
		return null;
	}
}
