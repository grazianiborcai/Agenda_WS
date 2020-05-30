package br.com.mind5.business.calendarDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.month.info.MonthInfo;

final class CalateVisiMergeMonth implements InfoMergerVisitorV3<CalateInfo, MonthInfo> {
	
	@Override public List<CalateInfo> beforeMerge(List<CalateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalateInfo baseInfo, MonthInfo selectedInfo) {
		return baseInfo.month == selectedInfo.month;
	}
	
	
	
	@Override public List<CalateInfo> merge(CalateInfo baseInfo, MonthInfo selectedInfo) {
		List<CalateInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CalateInfo> getUniquifier() {
		return null;
	}
}
