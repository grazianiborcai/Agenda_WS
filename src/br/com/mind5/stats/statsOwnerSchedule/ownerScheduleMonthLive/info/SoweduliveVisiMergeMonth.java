package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SoweduliveVisiMergeMonth extends InfoMergerVisitorTemplate<SoweduliveInfo, MonthInfo> {

	@Override public boolean shouldMerge(SoweduliveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SoweduliveInfo> merge(SoweduliveInfo baseInfo, MonthInfo selectedInfo) {
		List<SoweduliveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
