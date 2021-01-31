package br.com.mind5.business.cartCounter.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartouVisiMergeUsername extends InfoMergerVisitorTemplate<CartouInfo, UsernameInfo> {

	@Override public boolean shouldMerge(CartouInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<CartouInfo> merge(CartouInfo baseInfo, UsernameInfo selectedInfo) {
		List<CartouInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
