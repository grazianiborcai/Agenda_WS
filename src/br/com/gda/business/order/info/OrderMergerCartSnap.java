package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.info.InfoMerger_;

final class OrderMergerCartSnap extends InfoMerger_<OrderInfo, CartSnapInfo, OrderInfo> {
	public OrderInfo merge(CartSnapInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisiCartSnap());
	}
	
	
	
	public List<OrderInfo> merge(List<CartSnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisiCartSnap());
	}
}
