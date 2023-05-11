package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;

final class SowusMergerVisiStatarch extends InfoMergerVisitorTemplate<SowusInfo, StatarchInfo> {

	@Override public boolean shouldMerge(SowusInfo baseInfo, StatarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SowusInfo> merge(SowusInfo baseInfo, StatarchInfo selectedInfo) {
		List<SowusInfo> results = new ArrayList<>();
		
		baseInfo.city 		= "N/A";
		baseInfo.codState 	= selectedInfo.codState;
		baseInfo.txtState 	= selectedInfo.txtState;
		baseInfo.codCountry = selectedInfo.codCountry;
		baseInfo.txtCountry = selectedInfo.txtCountry;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
