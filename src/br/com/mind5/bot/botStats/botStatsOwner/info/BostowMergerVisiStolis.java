package br.com.mind5.bot.botStats.botStatsOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BostowMergerVisiStolis extends InfoMergerVisitorTemplate<BostowInfo, StolisInfo> {

	@Override public boolean shouldMerge(BostowInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BostowInfo> merge(BostowInfo baseInfo, StolisInfo selectedInfo) {
		List<BostowInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = "N/A";
		baseInfo.codState 	= "N/A";
		baseInfo.city 		= "N/A";
		
		
		if (selectedInfo.addressData != null) {
			baseInfo.codCountry = selectedInfo.addressData.codCountry;
			baseInfo.codState 	= selectedInfo.addressData.codState;
			baseInfo.city 		= "N/A";
		}
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
