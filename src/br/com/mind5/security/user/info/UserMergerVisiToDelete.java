package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerVisiToDelete extends InfoMergerVisitorTemplate<UserInfo, UserInfo> {
	
	@Override public boolean shouldMerge(UserInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser		);
	}	
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, UserInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		selectedInfo.lastChangedBy = baseInfo.lastChangedBy;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public List<UserInfo> uniquifyHook(List<UserInfo> results) {
		InfoUniquifier<UserInfo> uniquifier = new UserUniquifier();		
		return uniquifier.uniquify(results);
	}
}
