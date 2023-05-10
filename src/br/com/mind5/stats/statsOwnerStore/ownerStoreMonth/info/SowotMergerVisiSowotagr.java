package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;

final class SowotMergerVisiSowotagr extends InfoMergerVisitorTemplate<SowotInfo, SowotagrInfo> {

	@Override public boolean shouldMerge(SowotInfo baseInfo, SowotagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner 			&&
				baseInfo.calmonth.equals(selectedInfo.calmonth) 	&&
				baseInfo.codCountry.equals(selectedInfo.codCountry) &&
				baseInfo.codState.equals(selectedInfo.codState) 	&&
				baseInfo.city.equals(selectedInfo.city) 				);
	}
	
	
	
	@Override public List<SowotInfo> merge(SowotInfo baseInfo, SowotagrInfo selectedInfo) {
		List<SowotInfo> results = new ArrayList<>();
		
		SowotInfo result = SowotInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
