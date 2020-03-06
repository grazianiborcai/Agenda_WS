package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class UserVisiMergeToDelete implements InfoMergerVisitorV3<UserInfo, UserInfo> {
	
	@Override public List<UserInfo> beforeMerge(List<UserInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UserInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser		);
	}	
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, UserInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserInfo> getUniquifier() {
		return new UserUniquifier();
	}
}
