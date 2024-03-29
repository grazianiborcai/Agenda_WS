package br.com.mind5.authorization.storeAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class StorauthMergerVisiUsername extends InfoMergerVisitorTemplate<StorauthInfo, UsernameInfo> {

	@Override public boolean shouldMerge(StorauthInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StorauthInfo> merge(StorauthInfo baseInfo, UsernameInfo selectedInfo) {
		List<StorauthInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
}
