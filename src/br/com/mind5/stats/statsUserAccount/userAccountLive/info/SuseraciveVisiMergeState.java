package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class SuseraciveVisiMergeState extends InfoMergerVisitorTemplate<SuseraciveInfo, StateInfo> {

	@Override public boolean shouldMerge(SuseraciveInfo baseInfo, StateInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry)	&&
				baseInfo.codState.equals(selectedInfo.codState)		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SuseraciveInfo> merge(SuseraciveInfo baseInfo, StateInfo selectedInfo) {
		List<SuseraciveInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
