package br.com.mind5.authorization.storeAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorauthMergerVisiSotarch extends InfoMergerVisitorTemplate<StorauthInfo, SotarchInfo> {

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
}
