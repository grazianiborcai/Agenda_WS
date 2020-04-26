package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CartVisiMergeOrder implements InfoMergerVisitorV3<CartInfo, OrderInfo> {
	
	@Override public List<CartInfo> beforeMerge(List<CartInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartInfo baseInfo, OrderInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, OrderInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		baseInfo.codOrder = selectedInfo.codOrder;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartInfo> getUniquifier() {
		return null;
	}
}
