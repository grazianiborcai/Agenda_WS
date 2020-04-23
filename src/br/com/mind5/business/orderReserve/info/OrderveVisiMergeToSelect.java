package br.com.mind5.business.orderReserve.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderveVisiMergeToSelect implements InfoMergerVisitorV3<OrderveInfo, OrderveInfo> {
	
	@Override public List<OrderveInfo> beforeMerge(List<OrderveInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrderveInfo> getUniquifier() {
		return null;
	}
}
