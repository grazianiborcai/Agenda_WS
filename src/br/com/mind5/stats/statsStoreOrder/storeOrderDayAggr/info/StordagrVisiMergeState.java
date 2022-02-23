package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class StordagrVisiMergeState extends InfoMergerVisitorTemplate<StordagrInfo, StateInfo> {

	@Override public boolean shouldMerge(StordagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StordagrInfo> merge(StordagrInfo baseInfo, StateInfo selectedInfo) {
		List<StordagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
