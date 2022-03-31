package br.com.mind5.business.scheduleYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;

final class SchedyearMergerVisiMontharch extends InfoMergerVisitorTemplate<SchedyearInfo, MontharchInfo> {

	@Override public boolean shouldMerge(SchedyearInfo baseInfo, MontharchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedyearInfo> merge(SchedyearInfo baseInfo, MontharchInfo selectedInfo) {
		List<SchedyearInfo> results = new ArrayList<>();
		
		baseInfo.monthes.add(MonthInfo.copyFrom(selectedInfo));
		
		results.add(baseInfo);
		return results;
	}
}
