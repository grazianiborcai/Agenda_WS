package br.com.gda.business.orderItem.info;

import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class OrderMergerCartSnap extends InfoMerger_<OrderInfo, CartSnapInfo, OrderInfo> {
	public OrderInfo merge(CartSnapInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisiCartSnap());
	}
	
	
	
	public List<OrderInfo> merge(List<CartSnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisiCartSnap());
	}
}
