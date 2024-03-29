package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderMergerVisiOrdnap extends InfoMergerVisitorTemplate<OrderInfo, OrdnapInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, OrdnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codOrder == selectedInfo.codOrder		); 
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, OrdnapInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
