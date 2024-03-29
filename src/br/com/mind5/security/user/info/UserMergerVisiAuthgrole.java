package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

final class UserMergerVisiAuthgrole extends InfoMergerVisitorTemplate<UserInfo, AuthgroleInfo> {
	
	@Override public boolean shouldMerge(UserInfo baseInfo, AuthgroleInfo selectedInfo) {
		return true;
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, AuthgroleInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.authgroles.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<UserInfo> uniquifyHook(List<UserInfo> results) {
		InfoUniquifier<UserInfo> uniquifier = new UserUniquifier();		
		return uniquifier.uniquify(results);
	}
}
