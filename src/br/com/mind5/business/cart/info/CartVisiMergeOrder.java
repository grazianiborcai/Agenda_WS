package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartVisiMergeOrder extends InfoMergerVisitorTemplate<CartInfo, OrderInfo> {

	@Override public boolean shouldMerge(CartInfo baseInfo, OrderInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, OrderInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		baseInfo.codOrder = selectedInfo.codOrder;
		
		results.add(baseInfo);
		return results;
	}
}
