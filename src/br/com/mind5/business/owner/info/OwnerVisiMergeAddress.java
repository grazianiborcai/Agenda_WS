package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergeAddress extends InfoMergerVisitorTemplate<OwnerInfo, AddressInfo> {
	
	@Override public List<OwnerInfo> beforeMerge(List<OwnerInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnerInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner 	&&
				baseInfo.codOwner 	== selectedInfo.codOwnerRef		);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, AddressInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.addresses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnerInfo> getUniquifier() {
		return new OwnerUniquifier();
	}
}
