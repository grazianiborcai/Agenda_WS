package br.com.gda.business.order.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class OrderCopyPayord extends InfoCopierTemplate<OrderInfo, PayordInfo>{
	
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
