package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SteddVisiMergeStolis extends InfoMergerVisitorTemplate<SteddInfo, StolisInfo> {

	@Override public boolean shouldMerge(SteddInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<SteddInfo> merge(SteddInfo baseInfo, StolisInfo selectedInfo) {
		List<SteddInfo> results = new ArrayList<>();
		
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
