package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergeAddress implements InfoMergerVisitorV3<StorapInfo, AddressInfo> {
	
	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner &&
				baseInfo.codAddress == selectedInfo.codAddress);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, AddressInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.codAddressSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
