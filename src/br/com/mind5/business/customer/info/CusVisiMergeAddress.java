package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusVisiMergeAddress extends InfoMergerVisitorTemplate<CusInfo, AddressInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&& 
				baseInfo.codCustomer == selectedInfo.codCustomer		);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, AddressInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.addresses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
