package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderVisiMergeOrderStatus implements InfoMergerVisitorV3<OrderInfo, OrderStatusInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderInfo baseInfo, OrderStatusInfo selectedInfo) {
		return (baseInfo.codOrderStatus.equals(selectedInfo.codOrderStatus));
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrderStatusInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtOrderStatus = selectedInfo.txtOrderStatus;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
