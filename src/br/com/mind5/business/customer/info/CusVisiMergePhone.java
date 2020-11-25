package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusVisiMergePhone extends InfoMergerVisitorTemplate<CusInfo, PhoneInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner && 
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, PhoneInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
