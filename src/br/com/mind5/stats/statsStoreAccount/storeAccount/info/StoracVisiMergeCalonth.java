package br.com.mind5.stats.statsStoreAccount.storeAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoracVisiMergeCalonth extends InfoMergerVisitorTemplate<StoracInfo, CalonthInfo> {

	@Override public boolean shouldMerge(StoracInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StoracInfo> merge(StoracInfo baseInfo, CalonthInfo selectedInfo) {
		List<StoracInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
