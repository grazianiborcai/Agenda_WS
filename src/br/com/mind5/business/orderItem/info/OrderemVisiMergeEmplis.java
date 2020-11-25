package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemVisiMergeEmplis extends InfoMergerVisitorTemplate<OrderemInfo, EmplisInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, EmplisInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.emplisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
