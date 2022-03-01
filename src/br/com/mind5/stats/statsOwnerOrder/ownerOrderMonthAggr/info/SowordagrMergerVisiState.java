package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowordagrMergerVisiState extends InfoMergerVisitorTemplate<SowordagrInfo, StateInfo> {

	@Override public boolean shouldMerge(SowordagrInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowordagrInfo> merge(SowordagrInfo baseInfo, StateInfo selectedInfo) {
		List<SowordagrInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
