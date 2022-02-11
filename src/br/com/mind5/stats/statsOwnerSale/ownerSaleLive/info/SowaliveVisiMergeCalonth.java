package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowaliveVisiMergeCalonth extends InfoMergerVisitorTemplate<SowaliveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowaliveInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SowaliveInfo> merge(SowaliveInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowaliveInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
