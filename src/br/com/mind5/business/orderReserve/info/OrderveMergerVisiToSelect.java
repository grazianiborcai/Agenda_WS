package br.com.mind5.business.orderReserve.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderveMergerVisiToSelect extends InfoMergerVisitorTemplate<OrderveInfo, OrderveInfo> {

	@Override public boolean shouldMerge(OrderveInfo baseInfo, OrderveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrderveInfo> merge(OrderveInfo baseInfo, OrderveInfo selectedInfo) {
		List<OrderveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
