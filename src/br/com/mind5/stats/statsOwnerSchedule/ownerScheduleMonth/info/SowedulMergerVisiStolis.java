package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowedulMergerVisiStolis extends InfoMergerVisitorTemplate<SowedulInfo, StolisInfo> {

	@Override public boolean shouldMerge(SowedulInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowedulInfo> merge(SowedulInfo baseInfo, StolisInfo selectedInfo) {
		List<SowedulInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = "N/A";
		baseInfo.txtCountry = "N/A";
		baseInfo.codState 	= "N/A";
		baseInfo.txtState 	= "N/A";
		baseInfo.city 		= "N/A";
		
		
		if (selectedInfo.addressData != null) {
			baseInfo.codCountry = selectedInfo.addressData.codCountry;
			baseInfo.txtCountry = selectedInfo.addressData.txtCountry;
			baseInfo.codState 	= selectedInfo.addressData.codState;
			baseInfo.txtState 	= selectedInfo.addressData.txtState;
			baseInfo.city 		= "N/A";
		}
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
