package br.com.mind5.authorization.storeAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorauthMergerVisiToSelect extends InfoMergerVisitorTemplate<StorauthInfo, StorauthInfo> {

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
}
