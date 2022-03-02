package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowusagrMergerVisiState extends InfoMergerVisitorTemplate<SowusagrInfo, StateInfo> {

	@Override public boolean shouldMerge(SowusagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowusagrInfo> merge(SowusagrInfo baseInfo, StateInfo selectedInfo) {
		List<SowusagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
