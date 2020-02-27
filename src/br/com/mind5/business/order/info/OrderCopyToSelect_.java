package br.com.mind5.business.order.info;

import br.com.mind5.info.InfoCopierTemplate;

final class OrderCopyToSelect_ extends InfoCopierTemplate<OrderInfo, OrderInfo>{
	
	public OrderCopyToSelect_() {
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
