package br.com.mind5.security.userAuthentication.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class UauthMergerVisiUselis extends InfoMergerVisitorTemplate<UauthInfo, UselisInfo> {

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
}
