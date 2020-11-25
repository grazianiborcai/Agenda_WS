package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusVisiMergeCusarch extends InfoMergerVisitorTemplate<CusInfo, CusarchInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, CusarchInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
