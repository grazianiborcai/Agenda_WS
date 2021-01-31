package br.com.mind5.business.home.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class HomeVisiMergeUsername extends InfoMergerVisitorTemplate<HomeInfo, UsernameInfo> {

	@Override public boolean shouldMerge(HomeInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<HomeInfo> merge(HomeInfo baseInfo, UsernameInfo selectedInfo) {
		List<HomeInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
