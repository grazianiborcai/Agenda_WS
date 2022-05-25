package br.com.mind5.business.storeManager.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class StomanMergerVisiUsername extends InfoMergerVisitorTemplate<StomanInfo, UsernameInfo> {

	@Override public boolean shouldMerge(StomanInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StomanInfo> merge(StomanInfo baseInfo, UsernameInfo selectedInfo) {
		List<StomanInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
