package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeAddress implements InfoMergerVisitorV3<StolisInfo, AddressInfo> {
	
	@Override public List<StolisInfo> beforeMerge(List<StolisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolisInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codStore 	== selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, AddressInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.addresses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolisInfo> getUniquifier() {
		return new StolisUniquifier();
	}
}
