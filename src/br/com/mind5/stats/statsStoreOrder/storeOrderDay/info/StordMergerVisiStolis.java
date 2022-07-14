package br.com.mind5.stats.statsStoreOrder.storeOrderDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StordMergerVisiStolis extends InfoMergerVisitorTemplate<StordInfo, StolisInfo> {

	@Override public boolean shouldMerge(StordInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<StordInfo> merge(StordInfo baseInfo, StolisInfo selectedInfo) {
		List<StordInfo> results = new ArrayList<>();
		
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
}
