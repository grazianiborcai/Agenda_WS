package br.com.mind5.security.storeAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StorauthVisiMergeUsername implements InfoMergerVisitorV3<StorauthInfo, UsernameInfo> {
	
	@Override public List<StorauthInfo> beforeMerge(List<StorauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorauthInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StorauthInfo> merge(StorauthInfo baseInfo, UsernameInfo selectedInfo) {
		List<StorauthInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codUserCategory = selectedInfo.codUserCategory;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorauthInfo> getUniquifier() {
		return null;
	}
}
