package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;

final class SowedulagrVisiMergeSowedularch extends InfoMergerVisitorTemplate<SowedulagrInfo, SowedularchInfo> {

	@Override public boolean shouldMerge(SowedulagrInfo baseInfo, SowedularchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowedulagrInfo> merge(SowedulagrInfo baseInfo, SowedularchInfo selectedInfo) {
		List<SowedulagrInfo> results = new ArrayList<>();		
		SowedulagrInfo result = SowedulagrInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
