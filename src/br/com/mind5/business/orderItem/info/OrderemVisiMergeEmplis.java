package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderemVisiMergeEmplis implements InfoMergerVisitorV3<OrderemInfo, EmplisInfo> {
	
	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
