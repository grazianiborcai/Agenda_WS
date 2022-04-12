package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhonapMergerVisiCuslis extends InfoMergerVisitorTemplate<PhonapInfo, CuslisInfo> {

	@Override public boolean shouldMerge(PhonapInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	&&
				baseInfo.codCustomer == selectedInfo.codCustomer	);
	}
	
	
	
	@Override public List<PhonapInfo> merge(PhonapInfo baseInfo, CuslisInfo selectedInfo) {
		List<PhonapInfo> results = new ArrayList<>();
		
		baseInfo.codCustomerSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
