package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class OrderemCopyCartem extends InfoCopierTemplate<OrderemInfo, CartemInfo>{
	
	public OrderemCopyCartem() {
		super();
	}
	
	
	
	@Override protected OrderemInfo makeCopyHook(CartemInfo source) {
		return OrderemInfo.copyFrom(source);
	}
}
