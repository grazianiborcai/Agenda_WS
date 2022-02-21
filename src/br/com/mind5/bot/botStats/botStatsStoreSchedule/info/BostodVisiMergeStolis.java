package br.com.mind5.bot.botStats.botStatsStoreSchedule.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BostodVisiMergeStolis extends InfoMergerVisitorTemplate<BostodInfo, StolisInfo> {

	@Override public boolean shouldMerge(BostodInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BostodInfo> merge(BostodInfo baseInfo, StolisInfo selectedInfo) {
		List<BostodInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
