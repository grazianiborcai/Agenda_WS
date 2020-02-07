package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderVisiMergeOrdarch implements InfoMergerVisitorV3<OrderInfo, OrdarchInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
