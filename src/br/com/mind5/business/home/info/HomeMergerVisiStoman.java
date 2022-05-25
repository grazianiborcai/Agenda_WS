package br.com.mind5.business.home.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class HomeMergerVisiStoman extends InfoMergerVisitorTemplate<HomeInfo, StomanInfo> {

	@Override public boolean shouldMerge(HomeInfo baseInfo, StomanInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<HomeInfo> merge(HomeInfo baseInfo, StomanInfo selectedInfo) {
		List<HomeInfo> results = new ArrayList<>();
		
		baseInfo.stomanes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
