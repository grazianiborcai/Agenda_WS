package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartVisiMergeCartem extends InfoMergerVisitorTemplate<CartInfo, CartemInfo> {

	@Override public boolean shouldMerge(CartInfo baseInfo, CartemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, CartemInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		baseInfo.cartems.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
