package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;

final class SowordVisiMergeSowordagr extends InfoMergerVisitorTemplate<SowordInfo, SowordagrInfo> {

	@Override public boolean shouldMerge(SowordInfo baseInfo, SowordagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner 			&&
				baseInfo.calmonth.equals(selectedInfo.calmonth) 	&&
				baseInfo.codCountry.equals(selectedInfo.codCountry) &&
				baseInfo.codState.equals(selectedInfo.codState) 	&&
				baseInfo.city.equals(selectedInfo.city) 				);
	}
	
	
	
	@Override public List<SowordInfo> merge(SowordInfo baseInfo, SowordagrInfo selectedInfo) {
		List<SowordInfo> results = new ArrayList<>();
		
		SowordInfo result = SowordInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
