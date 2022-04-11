package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerVisiOwnerap extends InfoMergerVisitorTemplate<OwnerInfo, OwnerapInfo> {

	@Override public boolean shouldMerge(OwnerInfo baseInfo, OwnerapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, OwnerapInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<OwnerInfo> uniquifyHook(List<OwnerInfo> results) {
		InfoUniquifier<OwnerInfo> uniquifier = new OwnerUniquifier();		
		return uniquifier.uniquify(results);
	}
}
