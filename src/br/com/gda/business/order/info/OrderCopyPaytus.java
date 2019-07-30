package br.com.gda.business.order.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;

final class OrderCopyPaytus extends InfoCopierTemplate<OrderInfo, PaytusInfo>{
	
	public OrderCopyPaytus() {
		super();
	}
	
	
	
	@Override protected OrderInfo makeCopyHook(PaytusInfo source) {		
		OrderInfo result = new OrderInfo();
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codOrderStatus = source.codOrderStatus;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
