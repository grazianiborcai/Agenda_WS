package br.com.mind5.business.orderItemSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemrapVisiMergeCuslis extends InfoMergerVisitorTemplate<OrdemrapInfo, CuslisInfo> {

	@Override public boolean shouldMerge(OrdemrapInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner     == selectedInfo.codOwner &&
				baseInfo.codCustomer  == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<OrdemrapInfo> merge(OrdemrapInfo baseInfo, CuslisInfo selectedInfo) {
		List<OrdemrapInfo> results = new ArrayList<>();
		
		baseInfo.codCustomerSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
