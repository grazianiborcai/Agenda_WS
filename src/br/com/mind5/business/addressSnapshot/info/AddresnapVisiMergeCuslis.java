package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddresnapVisiMergeCuslis extends InfoMergerVisitorTemplate<AddresnapInfo, CuslisInfo> {

	@Override public boolean shouldMerge(AddresnapInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner  	 == selectedInfo.codOwner	&&
				baseInfo.codCustomer == selectedInfo.codCustomer	);
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, CuslisInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		baseInfo.codCustomerSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
