package br.com.mind5.authorization.storeAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorauthVisiMergeSotarch implements InfoMergerVisitor<StorauthInfo, SotarchInfo> {
	
	@Override public List<StorauthInfo> beforeMerge(List<StorauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorauthInfo baseInfo, SotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<StorauthInfo> merge(StorauthInfo baseInfo, SotarchInfo selectedInfo) {
		List<StorauthInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorauthInfo> getUniquifier() {
		return null;
	}
}
