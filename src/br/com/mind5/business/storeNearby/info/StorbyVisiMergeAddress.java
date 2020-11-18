package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorbyVisiMergeAddress extends InfoMergerVisitorTemplate<StorbyInfo, AddressInfo> {
	
	@Override public List<StorbyInfo> beforeMerge(List<StorbyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorbyInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, AddressInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.addressData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorbyInfo> getUniquifier() {
		return null;
	}
}
