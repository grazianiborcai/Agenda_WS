package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemVisiMergeOrdemrap extends InfoMergerVisitorTemplate<OrderemInfo, OrdemrapInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, OrdemrapInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner &&
				baseInfo.codOrder 		== selectedInfo.codOrder &&
				baseInfo.codOrderItem 	== selectedInfo.codOrderItem); 
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, OrdemrapInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
