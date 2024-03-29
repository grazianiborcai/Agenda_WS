package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusMergerVisiCusnap extends InfoMergerVisitorTemplate<CusInfo, CusnapInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, CusnapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	&&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, CusnapInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
