package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderVisiMergeOrduge implements InfoMergerVisitor<OrderInfo, OrdugeInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
