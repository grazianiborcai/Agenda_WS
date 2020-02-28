package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

final class OrderCopyRefu extends InfoCopierTemplate<OrderInfo, RefuInfo>{
	
	public OrderCopyRefu() {
		super();
	}
	
	
	
	@Override protected OrderInfo makeCopyHook(RefuInfo source) {		
		OrderInfo result = new OrderInfo();
		
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codPayOrder = source.codPayOrder;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
