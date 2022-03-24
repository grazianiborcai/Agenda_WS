package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemMergerVisiOrduge extends InfoMergerVisitorTemplate<OrderemInfo, OrdugeInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, OrdugeInfo selectedInfo) {
		if (baseInfo.codOrderStatus == null)
			return true;
		
		return baseInfo.codOrderStatus.equals(selectedInfo.codOrderStatusOld);
	}
	
	

	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, OrdugeInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.codOrderStatus = selectedInfo.codOrderStatusNew;
		
		results.add(baseInfo);
		return results;
	}
}
