package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergeAddresnap implements InfoMergerVisitorV3<StorapInfo, AddresnapInfo> {
	
	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner   		== selectedInfo.codOwner	&&
				baseInfo.codAddress 		== selectedInfo.codAddress	&&
				baseInfo.codAddressSnapshot == selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, AddresnapInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.addressData = AddressInfo.copyFrom(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
