package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderMergerVisiToSelect extends InfoMergerVisitorTemplate<OrderInfo, OrderInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, OrderInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrderInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
