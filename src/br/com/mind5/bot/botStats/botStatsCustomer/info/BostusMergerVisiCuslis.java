package br.com.mind5.bot.botStats.botStatsCustomer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BostusMergerVisiCuslis extends InfoMergerVisitorTemplate<BostusInfo, StolisInfo> {

	@Override public boolean shouldMerge(BostusInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BostusInfo> merge(BostusInfo baseInfo, StolisInfo selectedInfo) {
		List<BostusInfo> results = new ArrayList<>();
		
		baseInfo.codCustomer = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
