package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class AddressVisiMergeAddarchStore extends InfoMergerVisitorTemplate<AddressInfo, AddarchInfo> {
	
	@Override public List<AddressInfo> beforeMerge(List<AddressInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<AddressInfo> getUniquifier() {
		return null;
	}
}
