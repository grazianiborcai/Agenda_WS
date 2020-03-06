package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class UserVisiMergeAuthGrRole implements InfoMergerVisitorV3<UserInfo, AuthGrRoleInfo> {
	
	@Override public List<UserInfo> beforeMerge(List<UserInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UserInfo baseInfo, AuthGrRoleInfo selectedInfo) {
		return true;
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, AuthGrRoleInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.authGrRoles.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserInfo> getUniquifier() {
		return new UserUniquifier();
	}
}
