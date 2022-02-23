package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class StoronagrVisiMergeState extends InfoMergerVisitorTemplate<StoronagrInfo, StateInfo> {

	@Override public boolean shouldMerge(StoronagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StoronagrInfo> merge(StoronagrInfo baseInfo, StateInfo selectedInfo) {
		List<StoronagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
