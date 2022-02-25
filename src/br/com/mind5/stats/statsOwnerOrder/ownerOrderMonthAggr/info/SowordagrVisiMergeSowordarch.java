package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;

final class SowordagrVisiMergeSowordarch extends InfoMergerVisitorTemplate<SowordagrInfo, SowordarchInfo> {

	@Override public boolean shouldMerge(SowordagrInfo baseInfo, SowordarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowordagrInfo> merge(SowordagrInfo baseInfo, SowordarchInfo selectedInfo) {
		List<SowordagrInfo> results = new ArrayList<>();		
		SowordagrInfo result = SowordagrInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
