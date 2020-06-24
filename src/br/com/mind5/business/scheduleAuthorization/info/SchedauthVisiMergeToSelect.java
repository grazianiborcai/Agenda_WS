package br.com.mind5.business.scheduleAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedauthVisiMergeToSelect implements InfoMergerVisitorV3<SchedauthInfo, SchedauthInfo> {
	
	@Override public List<SchedauthInfo> beforeMerge(List<SchedauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<SchedauthInfo> getUniquifier() {
		return null;
	}
}
