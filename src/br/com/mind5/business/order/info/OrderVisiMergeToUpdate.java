package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderVisiMergeToUpdate implements InfoMergerVisitorV3<OrderInfo, OrderInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderInfo baseInfo, OrderInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrderInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		selectedInfo.codPayOrder = baseInfo.codPayOrder;
		selectedInfo.codPayPartner = baseInfo.codPayPartner;
		selectedInfo.statusOrderPartner = baseInfo.statusOrderPartner;
		selectedInfo.statusPaymentPartner = baseInfo.statusPaymentPartner;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
