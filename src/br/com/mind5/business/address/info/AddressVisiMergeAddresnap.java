package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class AddressVisiMergeAddresnap extends InfoMergerVisitorTemplate<AddressInfo, AddresnapInfo> {
	
	@Override public List<AddressInfo> beforeMerge(List<AddressInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddressInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codAddress == selectedInfo.codAddress		);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, AddresnapInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddressInfo> getUniquifier() {
		return null;
	}
}
