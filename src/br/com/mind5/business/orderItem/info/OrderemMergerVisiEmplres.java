package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemMergerVisiEmplres extends InfoMergerVisitorTemplate<OrderemInfo, EmplresInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, EmplresInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.emplresData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
