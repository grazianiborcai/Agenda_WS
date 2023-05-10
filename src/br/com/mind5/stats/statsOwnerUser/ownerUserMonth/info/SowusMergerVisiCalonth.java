package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowusMergerVisiCalonth extends InfoMergerVisitorTemplate<SowusInfo, CalonthInfo> {

	@Override public boolean shouldMerge(SowusInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SowusInfo> merge(SowusInfo baseInfo, CalonthInfo selectedInfo) {
		List<SowusInfo> results = new ArrayList<>();		
		
		baseInfo.year     = selectedInfo.year;
		baseInfo.month    = selectedInfo.month;
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
