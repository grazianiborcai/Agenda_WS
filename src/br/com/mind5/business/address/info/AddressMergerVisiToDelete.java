package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddressMergerVisiToDelete extends InfoMergerVisitorTemplate<AddressInfo, AddressInfo> {

	@Override public boolean shouldMerge(AddressInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, AddressInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
