package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserMergerToSelect extends InfoMergerTemplate_<UserInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, UserInfo> getVisitorHook() {
		return new UserVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
