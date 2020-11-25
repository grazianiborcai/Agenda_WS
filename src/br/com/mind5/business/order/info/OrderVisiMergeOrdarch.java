package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderVisiMergeOrdarch extends InfoMergerVisitorTemplate<OrderInfo, OrdarchInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, OrdarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner); 
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrdarchInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		OrderInfo result;
		
		result = OrderInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
