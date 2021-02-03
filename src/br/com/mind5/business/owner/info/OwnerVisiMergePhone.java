package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergePhone extends InfoMergerVisitorTemplate<OwnerInfo, PhoneInfo> {

	@Override public boolean shouldMerge(OwnerInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner 	&&
				baseInfo.codOwner 	== selectedInfo.codOwnerRef		);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, PhoneInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<OwnerInfo> uniquifyHook(List<OwnerInfo> results) {
		InfoUniquifier<OwnerInfo> uniquifier = new OwnerUniquifier();		
		return uniquifier.uniquify(results);
	}
}
