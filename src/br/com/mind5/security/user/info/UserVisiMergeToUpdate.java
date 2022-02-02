package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UserVisiMergeToUpdate extends InfoMergerVisitorTemplate<UserInfo, UserInfo> {
	
	@Override public boolean shouldMerge(UserInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, UserInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		baseInfo.username = selectedInfo.username;
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		baseInfo.codUserCategory = selectedInfo.codUserCategory;
		baseInfo.codAuthGroup = selectedInfo.codAuthGroup;		
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<UserInfo> uniquifyHook(List<UserInfo> results) {
		InfoUniquifier<UserInfo> uniquifier = new UserUniquifier();		
		return uniquifier.uniquify(results);
	}
}
