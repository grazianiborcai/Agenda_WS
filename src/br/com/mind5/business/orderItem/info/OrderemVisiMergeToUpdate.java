package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OrderemVisiMergeToUpdate extends InfoMergerVisitorTemplate<OrderemInfo, OrderemInfo> {

	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderemInfo baseInfo, OrderemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, OrderemInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		selectedInfo.codPayOrder = baseInfo.codPayOrder;
		selectedInfo.codPayOrderItem = baseInfo.codPayOrderItem;
		selectedInfo.statusOrderPartner = baseInfo.statusOrderPartner;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
