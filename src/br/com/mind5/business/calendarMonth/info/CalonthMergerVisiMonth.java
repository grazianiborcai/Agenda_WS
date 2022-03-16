package br.com.mind5.business.calendarMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class CalonthMergerVisiMonth extends InfoMergerVisitorTemplate<CalonthInfo, MonthInfo> {

	@Override public boolean shouldMerge(CalonthInfo baseInfo, MonthInfo selectedInfo) {
		return baseInfo.month == selectedInfo.month;
	}
	
	
	
	@Override public List<CalonthInfo> merge(CalonthInfo baseInfo, MonthInfo selectedInfo) {
		List<CalonthInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
