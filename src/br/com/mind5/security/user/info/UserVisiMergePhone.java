package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UserVisiMergePhone extends InfoMergerVisitorTemplate<UserInfo, PhoneInfo> {
	
	@Override public List<UserInfo> beforeMerge(List<UserInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UserInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, PhoneInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserInfo> getUniquifier() {
		return new UserUniquifier();
	}
}
