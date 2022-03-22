package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddressMergerVisiAddault extends InfoMergerVisitorTemplate<AddressInfo, AddaultInfo> {

	@Override public boolean shouldMerge(AddressInfo baseInfo, AddaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, AddaultInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		AddressInfo result = AddressInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
