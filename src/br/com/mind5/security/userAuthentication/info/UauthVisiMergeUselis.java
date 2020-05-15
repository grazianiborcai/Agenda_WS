package br.com.mind5.security.userAuthentication.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class UauthVisiMergeUselis implements InfoMergerVisitorV3<UauthInfo, UselisInfo> {
	
	@Override public List<UauthInfo> beforeMerge(List<UauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UauthInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<UauthInfo> merge(UauthInfo baseInfo, UselisInfo selectedInfo) {
		List<UauthInfo> results = new ArrayList<>();
		
		UauthInfo result = UauthInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UauthInfo> getUniquifier() {
		return null;
	}
}
