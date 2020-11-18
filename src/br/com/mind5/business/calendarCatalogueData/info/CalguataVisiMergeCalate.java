package br.com.mind5.business.calendarCatalogueData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CalguataVisiMergeCalate extends InfoMergerVisitorTemplate<CalguataInfo, CalateInfo> {
	
	@Override public List<CalguataInfo> beforeMerge(List<CalguataInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalguataInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.year  == selectedInfo.year && 
				baseInfo.month == selectedInfo.month	);
	}
	
	
	
	@Override public List<CalguataInfo> merge(CalguataInfo baseInfo, CalateInfo selectedInfo) {
		List<CalguataInfo> results = new ArrayList<>();
		
		CalguataInfo baseCopy = CloneUtil.cloneRecord(baseInfo, this.getClass());
		
		baseCopy.date = selectedInfo.date;
		baseCopy.day = selectedInfo.day;
		baseCopy.codWeekday = selectedInfo.codWeekday;
		
		results.add(baseCopy);
		return results;
	}
	
	
		
	@Override public InfoUniquifier<CalguataInfo> getUniquifier() {
		return null;
	}
}
