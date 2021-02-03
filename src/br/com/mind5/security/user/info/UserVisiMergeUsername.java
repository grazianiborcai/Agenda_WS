package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class UserVisiMergeUsername extends InfoMergerVisitorTemplate<UserInfo, UsernameInfo> {
	
	@Override public boolean shouldMerge(UserInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, UsernameInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<UserInfo> uniquifyHook(List<UserInfo> results) {
		InfoUniquifier<UserInfo> uniquifier = new UserUniquifier();		
		return uniquifier.uniquify(results);
	}
}
