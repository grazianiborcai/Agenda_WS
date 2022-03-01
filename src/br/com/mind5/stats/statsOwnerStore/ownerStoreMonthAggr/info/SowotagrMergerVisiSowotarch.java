package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

final class SowotagrMergerVisiSowotarch extends InfoMergerVisitorTemplate<SowotagrInfo, SowotarchInfo> {

	@Override public boolean shouldMerge(SowotagrInfo baseInfo, SowotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowotagrInfo> merge(SowotagrInfo baseInfo, SowotarchInfo selectedInfo) {
		List<SowotagrInfo> results = new ArrayList<>();		
		SowotagrInfo result = SowotagrInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
