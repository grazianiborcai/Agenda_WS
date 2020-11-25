package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderVisiMergeOrderem extends InfoMergerVisitorTemplate<OrderInfo, OrderemInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, OrderemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codOrder == selectedInfo.codOrder	);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrderemInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.orderms.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
