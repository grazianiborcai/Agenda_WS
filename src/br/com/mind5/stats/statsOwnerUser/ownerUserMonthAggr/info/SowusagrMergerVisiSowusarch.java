package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;

final class SowusagrMergerVisiSowusarch extends InfoMergerVisitorTemplate<SowusagrInfo, SowusarchInfo> {

	@Override public boolean shouldMerge(SowusagrInfo baseInfo, SowusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowusagrInfo> merge(SowusagrInfo baseInfo, SowusarchInfo selectedInfo) {
		List<SowusagrInfo> results = new ArrayList<>();		
		SowusagrInfo result = SowusagrInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
