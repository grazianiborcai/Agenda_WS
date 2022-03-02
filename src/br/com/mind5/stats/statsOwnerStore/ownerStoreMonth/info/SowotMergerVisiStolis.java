package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowotMergerVisiStolis extends InfoMergerVisitorTemplate<SowotInfo, StolisInfo> {

	@Override public boolean shouldMerge(SowotInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowotInfo> merge(SowotInfo baseInfo, StolisInfo selectedInfo) {
		List<SowotInfo> results = new ArrayList<>();
		
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
