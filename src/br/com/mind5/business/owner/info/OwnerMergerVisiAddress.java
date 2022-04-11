package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerVisiAddress extends InfoMergerVisitorTemplate<OwnerInfo, AddressInfo> {

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
	
	
	
	@Override public List<OwnerInfo> uniquifyHook(List<OwnerInfo> results) {
		InfoUniquifier<OwnerInfo> uniquifier = new OwnerUniquifier();		
		return uniquifier.uniquify(results);
	}
}
