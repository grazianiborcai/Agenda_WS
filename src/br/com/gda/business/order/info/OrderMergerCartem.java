package br.com.gda.business.order.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerCartem extends InfoMergerTemplate<OrderInfo, CartemInfo> {

	@Override protected InfoMergerVisitorV2<OrderInfo, CartemInfo> getVisitorHook() {
		return new OrderVisiMergeCartem();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
