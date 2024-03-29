package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedinapMergerVisiCuslis extends InfoMergerVisitorTemplate<SchedinapInfo, CuslisInfo> {

	@Override public boolean shouldMerge(SchedinapInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner && 
				baseInfo.codCustomer == selectedInfo.codCustomer	);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, CuslisInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		baseInfo.codCustomerSnapshot = selectedInfo.codSnapshot;
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
