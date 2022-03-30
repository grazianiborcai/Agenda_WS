package br.com.mind5.business.home.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userHome.info.UsomeInfo;

final class HomeMergerVisiUsome extends InfoMergerVisitorTemplate<HomeInfo, UsomeInfo> {

	@Override public boolean shouldMerge(HomeInfo baseInfo, UsomeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	
	@Override public List<HomeInfo> merge(HomeInfo baseInfo, UsomeInfo selectedInfo) {
		List<HomeInfo> results = new ArrayList<>();
		
		baseInfo.usome = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
