package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiCuslis extends InfoMergerVisitorTemplate<CusparInfo, CuslisInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, CuslisInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codUser             = selectedInfo.codUser;
		baseInfo.codCustomerSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
