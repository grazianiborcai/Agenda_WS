package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;

final class SowusMergerVisiSowusagr extends InfoMergerVisitorTemplate<SowusInfo, SowusagrInfo> {

	@Override public boolean shouldMerge(SowusInfo baseInfo, SowusagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner 			&&
				baseInfo.calmonth.equals(selectedInfo.calmonth) 	&&
				baseInfo.codCountry.equals(selectedInfo.codCountry) &&
				baseInfo.codState.equals(selectedInfo.codState) 	&&
				baseInfo.city.equals(selectedInfo.city) 				);
	}
	
	
	
	@Override public List<SowusInfo> merge(SowusInfo baseInfo, SowusagrInfo selectedInfo) {
		List<SowusInfo> results = new ArrayList<>();
		
		SowusInfo result = SowusInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
