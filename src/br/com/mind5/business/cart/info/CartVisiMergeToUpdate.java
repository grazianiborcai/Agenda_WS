package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartVisiMergeToUpdate extends InfoMergerVisitorTemplate<CartInfo, CartInfo> {

	@Override public boolean shouldMerge(CartInfo baseInfo, CartInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, CartInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
