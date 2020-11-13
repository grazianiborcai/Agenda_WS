package br.com.mind5.authorization.scheduleAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedauthVisiMergeSotarch implements InfoMergerVisitor<SchedauthInfo, SotarchInfo> {
	
	@Override public List<SchedauthInfo> beforeMerge(List<SchedauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedauthInfo baseInfo, SotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedauthInfo> merge(SchedauthInfo baseInfo, SotarchInfo selectedInfo) {
		List<SchedauthInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedauthInfo> getUniquifier() {
		return null;
	}
}
