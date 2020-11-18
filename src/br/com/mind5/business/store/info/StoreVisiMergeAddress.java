package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreVisiMergeAddress extends InfoMergerVisitorTemplate<StoreInfo, AddressInfo> {
	
	@Override public List<StoreInfo> beforeMerge(List<StoreInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoreInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, AddressInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.addressData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoreInfo> getUniquifier() {
		return new StoreUniquifier();
	}
}
