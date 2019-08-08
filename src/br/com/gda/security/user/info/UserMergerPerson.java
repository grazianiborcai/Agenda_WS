package br.com.gda.security.user.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserMergerPerson extends InfoMergerTemplate<UserInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<UserInfo, PersonInfo> getVisitorHook() {
		return new UserVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
