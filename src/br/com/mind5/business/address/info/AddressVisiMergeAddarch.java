package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddressVisiMergeAddarch extends InfoMergerVisitorTemplate<AddressInfo, AddarchInfo> {

	@Override public boolean shouldMerge(AddressInfo baseInfo, AddarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, AddarchInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		AddressInfo result = AddressInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
