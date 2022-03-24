package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemMergerVisiOrdemarch extends InfoMergerVisitorTemplate<OrderemInfo, OrdemarchInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, OrdemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, OrdemarchInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		OrderemInfo result = OrderemInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
