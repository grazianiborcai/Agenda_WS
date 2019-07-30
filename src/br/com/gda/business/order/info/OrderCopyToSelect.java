package br.com.gda.business.order.info;

import br.com.gda.info.InfoCopierTemplate;

final class OrderCopyToSelect extends InfoCopierTemplate<OrderInfo, OrderInfo>{
	
	public OrderCopyToSelect() {
		super();
	}
	
	
	
	@Override protected OrderInfo makeCopyHook(OrderInfo source) {		
		OrderInfo result = new OrderInfo();
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
