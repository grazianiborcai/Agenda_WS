package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderMergerVisiOrduge extends InfoMergerVisitorTemplate<OrderInfo, OrdugeInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, OrdugeInfo selectedInfo) {
		if (baseInfo.codOrderStatus == null)
			return true;
		
		return baseInfo.codOrderStatus.equals(selectedInfo.codOrderStatusOld);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrdugeInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.codOrderStatus = selectedInfo.codOrderStatusNew;
		
		results.add(baseInfo);
		return results;
	}
}
