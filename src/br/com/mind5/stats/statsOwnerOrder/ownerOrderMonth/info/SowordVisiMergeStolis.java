package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowordVisiMergeStolis extends InfoMergerVisitorTemplate<SowordInfo, StolisInfo> {

	@Override public boolean shouldMerge(SowordInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowordInfo> merge(SowordInfo baseInfo, StolisInfo selectedInfo) {
		List<SowordInfo> results = new ArrayList<>();
		
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
