package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemVisiMergeOrdist extends InfoMergerVisitorTemplate<OrderemInfo, OrdistInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codOrder == selectedInfo.codOrder		);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, OrdistInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
