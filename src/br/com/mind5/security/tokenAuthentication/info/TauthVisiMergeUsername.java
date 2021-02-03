package br.com.mind5.security.tokenAuthentication.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class TauthVisiMergeUsername extends InfoMergerVisitorTemplate<TauthInfo, UsernameInfo> {

	@Override public boolean shouldMerge(TauthInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<TauthInfo> merge(TauthInfo baseInfo, UsernameInfo selectedInfo) {
		List<TauthInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.authgroles.addAll(selectedInfo.authgroles);
		
		results.add(baseInfo);
		return results;
	}
}
