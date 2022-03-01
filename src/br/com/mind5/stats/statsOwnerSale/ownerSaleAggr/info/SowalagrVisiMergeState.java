package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowalagrVisiMergeState extends InfoMergerVisitorTemplate<SowalagrInfo, StateInfo> {

	@Override public boolean shouldMerge(SowalagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowalagrInfo> merge(SowalagrInfo baseInfo, StateInfo selectedInfo) {
		List<SowalagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
