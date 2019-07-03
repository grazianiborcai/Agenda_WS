package br.com.gda.payment.payOrderItem.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class OrderemCopyCartem extends InfoCopierTemplate<PayordemInfo, CartemInfo>{
	
	public OrderemCopyCartem() {
		super();
	}
	
	
	
	@Override protected PayordemInfo makeCopyHook(CartemInfo source) {
		return PayordemInfo.copyFrom(source);
	}
}
