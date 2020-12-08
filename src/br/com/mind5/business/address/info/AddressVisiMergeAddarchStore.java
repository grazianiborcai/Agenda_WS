package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddressVisiMergeAddarchStore extends InfoMergerVisitorTemplate<AddressInfo, AddarchInfo> {

	@Override public boolean shouldMerge(AddressInfo baseInfo, AddarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, AddarchInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.codAddress = selectedInfo.codAddress;
		
		results.add(baseInfo);
		return results;
	}
}
