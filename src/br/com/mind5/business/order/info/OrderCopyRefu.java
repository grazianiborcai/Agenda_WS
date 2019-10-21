package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

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
