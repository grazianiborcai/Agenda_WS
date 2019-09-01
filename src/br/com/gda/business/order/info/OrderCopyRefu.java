package br.com.gda.business.order.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.refundOrder.info.RefuInfo;

final class OrderCopyRefu extends InfoCopierTemplate<OrderInfo, RefuInfo>{
	
	public OrderCopyRefu() {
		super();
	}
	
	
	
	@Override protected OrderInfo makeCopyHook(RefuInfo source) {		
		OrderInfo result = new OrderInfo();
		result.codOwner = source.payordData.codOwner;
		result.codOrder = source.payordData.codOrder;
		result.codPayOrder = source.payordData.codPayOrder;
		result.codLanguage = source.payordData.codLanguage;
		result.username = source.payordData.username;
		
		return result;
	}
}
