package br.com.mind5.security.user.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerPerson extends InfoMergerTemplate<UserInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<UserInfo, PersonInfo> getVisitorHook() {
		return new UserVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
