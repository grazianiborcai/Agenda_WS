package br.com.gda.business.orderItem.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class OrderemCopyCartem extends InfoCopierTemplate<OrderemInfo, CartemInfo>{
	
	public OrderemCopyCartem() {
		super();
	}
	
	
	
	@Override protected OrderemInfo makeCopyHook(CartemInfo source) {
		return OrderemInfo.copyFrom(source);
	}
}
