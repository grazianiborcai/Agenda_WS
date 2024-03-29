package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class UserMergerVisiUserarch extends InfoMergerVisitorTemplate<UserInfo, UserarchInfo> {
	
	@Override public boolean shouldMerge(UserInfo baseInfo, UserarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, UserarchInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		UserInfo result = UserInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public List<UserInfo> uniquifyHook(List<UserInfo> results) {
		InfoUniquifier<UserInfo> uniquifier = new UserUniquifier();		
		return uniquifier.uniquify(results);
	}
}
