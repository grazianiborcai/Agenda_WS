package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UserVisiMergePerson extends InfoMergerVisitorTemplate<UserInfo, PersonInfo> {
	
	@Override public boolean shouldMerge(UserInfo baseInfo, PersonInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, PersonInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.personData = selectedInfo;
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<UserInfo> uniquifyHook(List<UserInfo> results) {
		InfoUniquifier<UserInfo> uniquifier = new UserUniquifier();		
		return uniquifier.uniquify(results);
	}
}
