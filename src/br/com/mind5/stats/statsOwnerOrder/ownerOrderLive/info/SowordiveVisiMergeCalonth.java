package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowordiveVisiMergeCalonth extends InfoMergerVisitorTemplate<SowordiveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowordiveInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SowordiveInfo> merge(SowordiveInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowordiveInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
