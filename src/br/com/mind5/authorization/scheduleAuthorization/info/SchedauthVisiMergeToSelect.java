package br.com.mind5.authorization.scheduleAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedauthVisiMergeToSelect extends InfoMergerVisitorTemplate<SchedauthInfo, SchedauthInfo> {

	@Override public boolean shouldMerge(SchedauthInfo baseInfo, SchedauthInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedauthInfo> merge(SchedauthInfo baseInfo, SchedauthInfo selectedInfo) {
		List<SchedauthInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
