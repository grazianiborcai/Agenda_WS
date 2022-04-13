package br.com.mind5.authorization.scheduleAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedauthMergerVisiSotarch extends InfoMergerVisitorTemplate<SchedauthInfo, SotarchInfo> {

	@Override public boolean shouldMerge(SchedauthInfo baseInfo, SotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedauthInfo> merge(SchedauthInfo baseInfo, SotarchInfo selectedInfo) {
		List<SchedauthInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
