package br.com.mind5.stats.statsOwnerSale.ownerSale.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowalMergerVisiStolis extends InfoMergerVisitorTemplate<SowalInfo, StolisInfo> {

	@Override public boolean shouldMerge(SowalInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowalInfo> merge(SowalInfo baseInfo, StolisInfo selectedInfo) {
		List<SowalInfo> results = new ArrayList<>();
		
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
