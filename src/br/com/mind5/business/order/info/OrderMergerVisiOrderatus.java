package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;

final class OrderMergerVisiOrderatus extends InfoMergerVisitorTemplate<OrderInfo, OrderatusInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, OrderatusInfo selectedInfo) {
		return (baseInfo.codOrderStatus.equals(selectedInfo.codOrderStatus));
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrderatusInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtOrderStatus = selectedInfo.txtOrderStatus;
		
		results.add(baseInfo);
		return results;
	}
}
