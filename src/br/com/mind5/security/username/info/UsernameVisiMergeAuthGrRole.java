package br.com.mind5.security.username.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class UsernameVisiMergeAuthGrRole implements InfoMergerVisitorV3<UsernameInfo, AuthGrRoleInfo> {
	
	@Override public List<UsernameInfo> beforeMerge(List<UsernameInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UsernameInfo baseInfo, AuthGrRoleInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<UsernameInfo> merge(UsernameInfo baseInfo, AuthGrRoleInfo selectedInfo) {
		List<UsernameInfo> results = new ArrayList<>();
		
		baseInfo.authGrRoles.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UsernameInfo> getUniquifier() {
		return new UsernameUniquifier();
	}
}
