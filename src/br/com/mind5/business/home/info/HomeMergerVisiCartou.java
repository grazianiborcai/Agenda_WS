package br.com.mind5.business.home.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class HomeMergerVisiCartou extends InfoMergerVisitorTemplate<HomeInfo, CartouInfo> {

	@Override public boolean shouldMerge(HomeInfo baseInfo, CartouInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<HomeInfo> merge(HomeInfo baseInfo, CartouInfo selectedInfo) {
		List<HomeInfo> results = new ArrayList<>();
		
		baseInfo.cartouData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
