package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class StoroniveMergerVisiState extends InfoMergerVisitorTemplate<StoroniveInfo, StateInfo> {

	@Override public boolean shouldMerge(StoroniveInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StoroniveInfo> merge(StoroniveInfo baseInfo, StateInfo selectedInfo) {
		List<StoroniveInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
