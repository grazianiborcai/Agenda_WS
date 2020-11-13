package br.com.mind5.authorization.storeAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorauthVisiMergeToSelect implements InfoMergerVisitor<StorauthInfo, StorauthInfo> {
	
	@Override public List<StorauthInfo> beforeMerge(List<StorauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorauthInfo baseInfo, StorauthInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorauthInfo> merge(StorauthInfo baseInfo, StorauthInfo selectedInfo) {
		List<StorauthInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorauthInfo> getUniquifier() {
		return null;
	}
}
