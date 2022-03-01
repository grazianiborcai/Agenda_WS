package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SowaliveMergerVisiState extends InfoMergerVisitorTemplate<SowaliveInfo, StateInfo> {

	@Override public boolean shouldMerge(SowaliveInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowaliveInfo> merge(SowaliveInfo baseInfo, StateInfo selectedInfo) {
		List<SowaliveInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
