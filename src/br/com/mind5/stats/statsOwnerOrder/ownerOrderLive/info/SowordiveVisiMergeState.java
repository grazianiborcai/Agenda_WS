package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowordiveVisiMergeState extends InfoMergerVisitorTemplate<SowordiveInfo, StateInfo> {

	@Override public boolean shouldMerge(SowordiveInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowordiveInfo> merge(SowordiveInfo baseInfo, StateInfo selectedInfo) {
		List<SowordiveInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
