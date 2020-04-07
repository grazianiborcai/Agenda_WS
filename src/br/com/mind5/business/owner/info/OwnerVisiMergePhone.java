package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergePhone implements InfoMergerVisitorV3<OwnerInfo, PhoneInfo> {
	
	@Override public List<OwnerInfo> beforeMerge(List<OwnerInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OwnerInfo> getUniquifier() {
		return new OwnerUniquifier();
	}
}
