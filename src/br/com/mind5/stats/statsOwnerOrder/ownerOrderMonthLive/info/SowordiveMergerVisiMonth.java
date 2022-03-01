package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SowordiveMergerVisiMonth extends InfoMergerVisitorTemplate<SowordiveInfo, MonthInfo> {

	@Override public boolean shouldMerge(SowordiveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowordiveInfo> merge(SowordiveInfo baseInfo, MonthInfo selectedInfo) {
		List<SowordiveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
