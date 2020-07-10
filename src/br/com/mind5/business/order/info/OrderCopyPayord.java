package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class OrderCopyPayord extends InfoCopierTemplate<OrderInfo, PayordInfo> {
	
	public OrderCopyPayord() {
		super();
	}
	
	
	
	@Override protected OrderInfo makeCopyHook(PayordInfo source) {		
		OrderInfo result = new OrderInfo();
		
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codPayOrder = source.codPayOrder;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
