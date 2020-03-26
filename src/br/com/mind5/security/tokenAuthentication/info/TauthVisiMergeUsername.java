package br.com.mind5.security.tokenAuthentication.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class TauthVisiMergeUsername implements InfoMergerVisitorV3<TauthInfo, UsernameInfo> {
	
	@Override public List<TauthInfo> beforeMerge(List<TauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(TauthInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<TauthInfo> merge(TauthInfo baseInfo, UsernameInfo selectedInfo) {
		List<TauthInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.authGrRoles.addAll(selectedInfo.authGrRoles);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<TauthInfo> getUniquifier() {
		return null;
	}
}
