package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderMergerVisiToUpdate extends InfoMergerVisitorTemplate<OrderInfo, OrderInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, OrderInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrderInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		selectedInfo.codPayOrder = baseInfo.codPayOrder;
		selectedInfo.codPayPartner = baseInfo.codPayPartner;
		selectedInfo.statusOrderPartner = baseInfo.statusOrderPartner;
		selectedInfo.statusPaymentPartner = baseInfo.statusPaymentPartner;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
