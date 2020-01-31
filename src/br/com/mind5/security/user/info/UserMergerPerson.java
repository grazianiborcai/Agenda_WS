package br.com.mind5.security.user.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserMergerPerson extends InfoMergerTemplate_<UserInfo, PersonInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, PersonInfo> getVisitorHook() {
		return new UserVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
