package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class UserVisiMergeUserap extends InfoMergerVisitorTemplate<UserInfo, UserapInfo> {
	
	@Override public List<UserInfo> beforeMerge(List<UserInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UserInfo baseInfo, UserapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, UserapInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserInfo> getUniquifier() {
		return new UserUniquifier();
	}
}
