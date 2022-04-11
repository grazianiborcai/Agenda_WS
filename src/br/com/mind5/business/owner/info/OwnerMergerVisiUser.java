package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class OwnerMergerVisiUser extends InfoMergerVisitorTemplate<OwnerInfo, UserInfo> {

	@Override public boolean shouldMerge(OwnerInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, UserInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<OwnerInfo> uniquifyHook(List<OwnerInfo> results) {
		InfoUniquifier<OwnerInfo> uniquifier = new OwnerUniquifier();		
		return uniquifier.uniquify(results);
	}
}
