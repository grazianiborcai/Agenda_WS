package br.com.mind5.business.cartCounter.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartouMergerVisiCartem extends InfoMergerVisitorTemplate<CartouInfo, CartemInfo> {

	@Override public boolean shouldMerge(CartouInfo baseInfo, CartemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<CartouInfo> merge(CartouInfo baseInfo, CartemInfo selectedInfo) {
		List<CartouInfo> results = new ArrayList<>();
		
		baseInfo.cartems.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
